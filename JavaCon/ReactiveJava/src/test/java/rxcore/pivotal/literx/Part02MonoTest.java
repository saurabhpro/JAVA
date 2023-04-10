package rxcore.pivotal.literx;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.time.Duration;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 */
class Part02MonoTest {

    final Part02Mono workshop = new Part02Mono();

//========================================================================================

    @Test
    void empty() {
        var mono = workshop.emptyMono();
        StepVerifier.create(mono)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void noSignal() {
        var mono = workshop.monoWithNoSignal();
        StepVerifier
            .create(mono)
            .expectSubscription()
            .expectTimeout(Duration.ofSeconds(1))
            .verify();
    }

//========================================================================================

    @Test
    void fromValue() {
        var mono = workshop.fooMono();
        StepVerifier.create(mono)
            .expectNext("foo")
            .verifyComplete();
    }

//========================================================================================

    @Test
    void error() {
        var mono = workshop.errorMono();
        StepVerifier.create(mono)
            .verifyError(IllegalStateException.class);
    }

}
