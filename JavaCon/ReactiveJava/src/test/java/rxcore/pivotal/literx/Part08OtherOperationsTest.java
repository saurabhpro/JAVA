package rxcore.pivotal.literx;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.publisher.PublisherProbe;
import rxcore.pivotal.literx.domain.User;
import rxcore.pivotal.literx.repository.ReactiveRepository;
import rxcore.pivotal.literx.repository.ReactiveUserRepository;

import java.util.List;

import static rxcore.pivotal.literx.domain.User.JESSE;
import static rxcore.pivotal.literx.domain.User.SAUL;
import static rxcore.pivotal.literx.domain.User.SKYLER;
import static rxcore.pivotal.literx.domain.User.WALTER;

/**
 * Learn how to use various other operators.
 *
 * @author Sebastien Deleuze
 */
class Part08OtherOperationsTest {

    final static User MARIE = new User("mschrader", "Marie", "Schrader");
    final static User MIKE = new User("mehrmantraut", "Mike", "Ehrmantraut");
    final Part08OtherOperations workshop = new Part08OtherOperations();

//========================================================================================

    @Test
    void zipFirstNameAndLastName() {
        var usernameFlux = Flux.just(
            SKYLER.userName(),
            JESSE.userName(),
            WALTER.userName(),
            SAUL.userName());
        var firstnameFlux = Flux.just(
            SKYLER.firstName(),
            JESSE.firstName(),
            WALTER.firstName(),
            SAUL.firstName());
        var lastnameFlux = Flux.just(
            SKYLER.lastName(),
            JESSE.lastName(),
            WALTER.lastName(),
            SAUL.lastName());
        var userFlux = workshop.userFluxFromStringFlux(usernameFlux, firstnameFlux, lastnameFlux);
        StepVerifier.create(userFlux)
            .expectNext(SKYLER, JESSE, WALTER, SAUL)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void fastestMono() {
        ReactiveRepository<User> repository = new ReactiveUserRepository(MARIE);
        ReactiveRepository<User> repositoryWithDelay = new ReactiveUserRepository(250, MIKE);
        var mono = workshop.useFastestMono(repository.findFirst(), repositoryWithDelay.findFirst());
        StepVerifier.create(mono)
            .expectNext(MARIE)
            .verifyComplete();

        repository = new ReactiveUserRepository(250, MARIE);
        repositoryWithDelay = new ReactiveUserRepository(MIKE);
        mono = workshop.useFastestMono(repository.findFirst(), repositoryWithDelay.findFirst());
        StepVerifier.create(mono)
            .expectNext(MIKE)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void fastestFlux() {
        ReactiveRepository<User> repository = new ReactiveUserRepository(MARIE, MIKE);
        ReactiveRepository<User> repositoryWithDelay = new ReactiveUserRepository(250);
        var flux = workshop.useFastestFlux(repository.findAll(), repositoryWithDelay.findAll());
        StepVerifier.create(flux)
            .expectNext(MARIE, MIKE)
            .verifyComplete();

        repository = new ReactiveUserRepository(250, MARIE, MIKE);
        repositoryWithDelay = new ReactiveUserRepository();
        flux = workshop.useFastestFlux(repository.findAll(), repositoryWithDelay.findAll());
        StepVerifier.create(flux)
            .expectNext(SKYLER, JESSE, WALTER, SAUL)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void complete() {
        ReactiveRepository<User> repository = new ReactiveUserRepository();
        var probe = PublisherProbe.of(repository.findAll());
        var completion = workshop.fluxCompletion(probe.flux());
        StepVerifier.create(completion)
            .verifyComplete();
        probe.assertWasRequested();
    }

//========================================================================================

    @Test
    void nullHandling() {
        var mono = workshop.nullAwareUserToMono(SKYLER);
        StepVerifier.create(mono)
            .expectNext(SKYLER)
            .verifyComplete();
        mono = workshop.nullAwareUserToMono(null);
        StepVerifier.create(mono)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void emptyHandling() {
        var mono = workshop.emptyToSkyler(Mono.just(WALTER));
        StepVerifier.create(mono)
            .expectNext(WALTER)
            .verifyComplete();
        mono = workshop.emptyToSkyler(Mono.empty());
        StepVerifier.create(mono)
            .expectNext(SKYLER)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void collect() {
        ReactiveRepository<User> repository = new ReactiveUserRepository();
        var collection = workshop.fluxCollection(repository.findAll());
        StepVerifier.create(collection)
            .expectNext(List.of(SKYLER, JESSE, WALTER, SAUL))
            .verifyComplete();
    }

}
