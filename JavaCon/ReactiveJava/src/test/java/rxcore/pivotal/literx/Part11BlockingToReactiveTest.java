package rxcore.pivotal.literx;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;
import rxcore.pivotal.literx.domain.User;
import rxcore.pivotal.literx.repository.BlockingUserRepository;
import rxcore.pivotal.literx.repository.ReactiveRepository;
import rxcore.pivotal.literx.repository.ReactiveUserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static rxcore.pivotal.literx.domain.User.JESSE;
import static rxcore.pivotal.literx.domain.User.SAUL;
import static rxcore.pivotal.literx.domain.User.SKYLER;
import static rxcore.pivotal.literx.domain.User.WALTER;

/**
 * Learn how to call blocking code from Reactive one with adapted concurrency strategy for
 * blocking code that produces or receives data.
 * <p>
 * For those who know RxJava:
 * - RxJava subscribeOn = Reactor subscribeOn
 * - RxJava observeOn = Reactor publishOn
 *
 * @author Sebastien Deleuze
 * @see Flux#subscribeOn(Scheduler)
 * @see Flux#publishOn(Scheduler)
 * @see Schedulers
 */
class Part11BlockingToReactiveTest {

    final Part11BlockingToReactive workshop = new Part11BlockingToReactive();

//========================================================================================

    @Test
    void slowPublisherFastSubscriber() {
        var repository = new BlockingUserRepository();
        var flux = workshop.blockingRepositoryToFlux(repository);
        assertThat(repository.getCallCount())
            .withFailMessage("The call to findAll must be deferred until the flux is subscribed")
            .isZero();
        StepVerifier.create(flux)
            .expectNext(SKYLER, JESSE, WALTER, SAUL)
            .verifyComplete();
    }

//========================================================================================

    @Disabled
    @Test
    void fastPublisherSlowSubscriber() {
        ReactiveRepository<User> reactiveRepository = new ReactiveUserRepository();
        var blockingRepository = new BlockingUserRepository(new User[]{});

        var complete = workshop.fluxToBlockingRepository(reactiveRepository.findAll(), blockingRepository);
        assertThat(blockingRepository.getCallCount())
            .isZero();

        StepVerifier.create(complete)
            .verifyComplete();
        var users = blockingRepository.findAll();

        assertThat(users).containsExactly(SKYLER, JESSE, WALTER, SAUL);
    }

}
