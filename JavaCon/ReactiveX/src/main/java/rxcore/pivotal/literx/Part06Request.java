package rxcore.pivotal.literx;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import rxcore.pivotal.literx.domain.User;
import rxcore.pivotal.literx.repository.ReactiveRepository;
import rxcore.pivotal.literx.repository.ReactiveUserRepository;

import static rxcore.pivotal.literx.domain.User.JESSE;
import static rxcore.pivotal.literx.domain.User.SKYLER;

/**
 * Learn how to control the demand.
 *
 * @author Sebastien Deleuze
 */
public class Part06Request {

    ReactiveRepository<User> repository = new ReactiveUserRepository();

//========================================================================================

    // Create a StepVerifier that initially requests all values and expect 4 values to be received
    StepVerifier requestAllExpectFour(Flux<User> flux) {
        return StepVerifier.create(flux)
            .expectNextCount(4)
            .expectComplete();
    }

//========================================================================================

    // Create a StepVerifier that initially requests 1 value and expects User.SKYLER then requests another value and expects User.JESSE then stops verifying by cancelling the source
    StepVerifier requestOneExpectSkylerThenRequestOneExpectJesse(Flux<User> flux) {
        return StepVerifier.create(flux, 1)
            .expectNext(SKYLER)
            .thenRequest(1)
            .expectNext(JESSE)
            .thenCancel();
    }

//========================================================================================

    // Return a Flux with all users stored in the repository that prints automatically logs for all Reactive Streams signals
    Flux<User> fluxWithLog() {
        return repository
            .findAll()
            .log();
    }

//========================================================================================

    // Return a Flux with all users stored in the repository that prints "Starring:" at first, "firstName lastName" for all values and "The end!" on complete
    Flux<User> fluxWithDoOnPrintln() {
        return repository
            .findAll()
            .doFirst(() -> System.out.println("Starring:"))
            .doOnNext(p -> System.out.println(p.firstName() + " " + p.lastName()))
            .doOnComplete(() -> System.out.println("The end!"));
    }

}
