package rxcore.pivotal.literx;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
class Part01FluxTest {

    final Part01Flux workshop = new Part01Flux();

//========================================================================================

    @Test
    void empty() {
        var flux = workshop.emptyFlux();

        StepVerifier.create(flux)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void fromValues() {
        var flux = workshop.fooBarFluxFromValues();
        StepVerifier.create(flux)
            .expectNext("foo", "bar")
            .verifyComplete();
    }

//========================================================================================

    @Test
    void fromList() {
        var flux = workshop.fooBarFluxFromList();
        StepVerifier.create(flux)
            .expectNext("foo", "bar")
            .verifyComplete();
    }

//========================================================================================

    @Test
    void error() {
        var flux = workshop.errorFlux();
        StepVerifier.create(flux)
            .verifyError(IllegalStateException.class);
    }

//========================================================================================

    @Test
    void countEach100ms() {
        var flux = workshop.counter();
        StepVerifier.create(flux)
            .expectNext(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L)
            .verifyComplete();
    }

}
