package rxcore.pivotal.literx.repository;

import rxcore.pivotal.literx.domain.User;

import java.util.concurrent.atomic.AtomicInteger;

import static reactor.core.publisher.Mono.just;

public class BlockingUserRepository implements BlockingRepository<User> {

    private final ReactiveRepository<User> reactiveRepository;

    private final AtomicInteger callCount = new AtomicInteger();

    public BlockingUserRepository() {
        reactiveRepository = new ReactiveUserRepository();
    }

    public BlockingUserRepository(long delayInMs) {
        reactiveRepository = new ReactiveUserRepository(delayInMs);
    }

    public BlockingUserRepository(User... users) {
        reactiveRepository = new ReactiveUserRepository(users);
    }

    public BlockingUserRepository(long delayInMs, User... users) {
        reactiveRepository = new ReactiveUserRepository(delayInMs, users);
    }

    @Override
    public void save(User user) {
        callCount.incrementAndGet();
        reactiveRepository.save(just(user)).block();
    }

    @Override
    public User findFirst() {
        callCount.incrementAndGet();
        return reactiveRepository.findFirst().block();
    }

    @Override
    public Iterable<User> findAll() {
        callCount.incrementAndGet();
        return reactiveRepository.findAll().toIterable();
    }

    @Override
    public User findById(String username) {
        callCount.incrementAndGet();
        return reactiveRepository.findById(username).block();
    }

    public int getCallCount() {
        return callCount.get();
    }
}
