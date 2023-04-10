package rxcore.pivotal.literx.repository;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rxcore.pivotal.literx.domain.User;

import java.time.Duration;
import java.util.List;

import static rxcore.pivotal.literx.domain.User.JESSE;
import static rxcore.pivotal.literx.domain.User.SAUL;
import static rxcore.pivotal.literx.domain.User.SKYLER;
import static rxcore.pivotal.literx.domain.User.WALTER;

public class ReactiveUserRepository implements ReactiveRepository<User> {

    private static final long DEFAULT_DELAY_IN_MS = 100;

    private final long delayInMs;

    private final List<User> users;

    public ReactiveUserRepository() {
        this(DEFAULT_DELAY_IN_MS);
    }

    public ReactiveUserRepository(long delayInMs) {
        this(delayInMs, SKYLER, JESSE, WALTER, SAUL);
    }

    public ReactiveUserRepository(User... users) {
        this(DEFAULT_DELAY_IN_MS, users);
    }

    public ReactiveUserRepository(long delayInMs, User... users) {
        this.delayInMs = delayInMs;
        this.users = List.of(users);
    }

    @Override
    public Mono<Void> save(Publisher<User> userPublisher) {
        return withDelay(Flux.from(userPublisher)).doOnNext(users::add).then();
    }

    @Override
    public Mono<User> findFirst() {
        return withDelay(Mono.just(users.get(0)));
    }

    @Override
    public Flux<User> findAll() {
        return withDelay(Flux.fromIterable(users));
    }

    @Override
    public Mono<User> findById(String username) {
        final var user = users.stream().filter(p -> p.userName().equals(username))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No user with userName " + username + " found!"));
        return withDelay(Mono.just(user));
    }

    private Mono<User> withDelay(Mono<User> userMono) {
        return Mono.delay(Duration.ofMillis(delayInMs))
            .flatMap(c -> userMono);
    }

    private Flux<User> withDelay(Flux<User> userFlux) {
        return Flux.interval(Duration.ofMillis(delayInMs))
            .zipWith(userFlux, (i, user) -> user);
    }

}
