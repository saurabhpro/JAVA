package rxcore.pivotal.literx;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import rxcore.pivotal.literx.domain.User;
import rxcore.pivotal.literx.repository.ReactiveRepository;
import rxcore.pivotal.literx.repository.ReactiveUserRepository;

/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 */
class Part04TransformTest {

    final Part04Transform workshop = new Part04Transform();
    final ReactiveRepository<User> repository = new ReactiveUserRepository();

//========================================================================================

    @Test
    void transformMono() {
        var mono = repository.findFirst();
        StepVerifier.create(workshop.capitalizeOne(mono))
            .expectNext(new User("SWHITE", "SKYLER", "WHITE"))
            .verifyComplete();
    }

//========================================================================================

    @Test
    void transformFlux() {
        var flux = repository.findAll();
        StepVerifier.create(workshop.capitalizeMany(flux))
            .expectNext(
                new User("SWHITE", "SKYLER", "WHITE"),
                new User("JPINKMAN", "JESSE", "PINKMAN"),
                new User("WWHITE", "WALTER", "WHITE"),
                new User("SGOODMAN", "SAUL", "GOODMAN"))
            .verifyComplete();
    }

//========================================================================================

    @Test
    void asyncTransformFlux() {
        var flux = repository.findAll();
        StepVerifier.create(workshop.asyncCapitalizeMany(flux))
            .expectNext(
                new User("SWHITE", "SKYLER", "WHITE"),
                new User("JPINKMAN", "JESSE", "PINKMAN"),
                new User("WWHITE", "WALTER", "WHITE"),
                new User("SGOODMAN", "SAUL", "GOODMAN"))
            .verifyComplete();
    }

}
