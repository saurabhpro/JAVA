package rxcore.pivotal.literx;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import rxcore.pivotal.literx.domain.User;
import rxcore.pivotal.literx.repository.ReactiveRepository;
import rxcore.pivotal.literx.repository.ReactiveUserRepository;

import static rxcore.pivotal.literx.domain.User.JESSE;
import static rxcore.pivotal.literx.domain.User.SAUL;
import static rxcore.pivotal.literx.domain.User.SKYLER;
import static rxcore.pivotal.literx.domain.User.WALTER;

/**
 * Learn how to merge flux.
 *
 * @author Sebastien Deleuze
 */
class Part05MergeTest {

    final static User MARIE = new User("mschrader", "Marie", "Schrader");
    final static User MIKE = new User("mehrmantraut", "Mike", "Ehrmantraut");
    final Part05Merge workshop = new Part05Merge();
    final ReactiveRepository<User> repositoryWithDelay = new ReactiveUserRepository(500);
    final ReactiveRepository<User> repository = new ReactiveUserRepository(MARIE, MIKE);

//========================================================================================

    @Test
    void mergeWithInterleave() {
        var flux = workshop.mergeFluxWithInterleave(repositoryWithDelay.findAll(), repository.findAll());
        StepVerifier.create(flux)
            .expectNext(MARIE, MIKE, SKYLER, JESSE, WALTER, SAUL)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void mergeWithNoInterleave() {
        var flux = workshop.mergeFluxWithNoInterleave(repositoryWithDelay.findAll(), repository.findAll());
        StepVerifier.create(flux)
            .expectNext(SKYLER, JESSE, WALTER, SAUL, MARIE, MIKE)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void multipleMonoToFlux() {
        var skylerMono = repositoryWithDelay.findFirst();
        var marieMono = repository.findFirst();
        var flux = workshop.createFluxFromMultipleMono(skylerMono, marieMono);
        StepVerifier.create(flux)
            .expectNext(SKYLER, MARIE)
            .verifyComplete();
    }

}
