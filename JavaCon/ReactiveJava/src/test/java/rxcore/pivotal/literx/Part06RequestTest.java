package rxcore.pivotal.literx;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import reactor.util.annotation.Nullable;
import rxcore.pivotal.literx.domain.User;
import rxcore.pivotal.literx.repository.ReactiveRepository;
import rxcore.pivotal.literx.repository.ReactiveUserRepository;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Learn how to control the demand.
 *
 * @author Sebastien Deleuze
 */
class Part06RequestTest {

    final Part06Request workshop = new Part06Request();
    final ReactiveRepository<User> repository = new ReactiveUserRepository();

    final PrintStream originalConsole = System.out;

    @Nullable //null when not useful
    ByteArrayOutputStream logConsole;

    @AfterEach
    void afterEach() {
        if (logConsole != null) {
            originalConsole.println(logConsole);
            System.setOut(originalConsole);
            logConsole = null;
        }
    }

//========================================================================================

    @Test
    void requestAll() {
        var flux = repository.findAll();
        var verifier = workshop.requestAllExpectFour(flux);
        verifier.verify();
    }

//========================================================================================

    @Test
    void requestOneByOne() {
        var flux = repository.findAll();
        var verifier = workshop.requestOneExpectSkylerThenRequestOneExpectJesse(flux);
        verifier.verify();
    }

//========================================================================================

    @Test
    void experimentWithLog() {
        logConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(logConsole));

        var flux = workshop.fluxWithLog();

        StepVerifier.create(flux, 0)
            .thenRequest(1)
            .expectNextMatches(u -> true)
            .thenRequest(1)
            .expectNextMatches(u -> true)
            .thenRequest(2)
            .expectNextMatches(u -> true)
            .expectNextMatches(u -> true)
            .verifyComplete();

        var log = Arrays.stream(logConsole.toString().split(System.lineSeparator()))
            .filter(s -> s.contains("] INFO"))
            .map(s -> s.replaceAll(".*] INFO .* -- ", ""))
            .toList();

        assertThat(log)
            .containsExactly("onSubscribe(FluxZip.ZipCoordinator)"
                , "request(1)"
                , "onNext(User[userName=swhite, firstName=Skyler, lastName=White])"
                , "request(1)"
                , "onNext(User[userName=jpinkman, firstName=Jesse, lastName=Pinkman])"
                , "request(2)"
                , "onNext(User[userName=wwhite, firstName=Walter, lastName=White])"
                , "onNext(User[userName=sgoodman, firstName=Saul, lastName=Goodman])"
                , "onComplete()");
    }

//========================================================================================

    @Test
    void experimentWithDoOn() {
        var flux = workshop.fluxWithDoOnPrintln();

        //setting up the logConsole here should ensure we only capture console logs from the Flux
        logConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(logConsole));

        StepVerifier.create(flux)
            .expectNextCount(4)
            .verifyComplete();

        var log = logConsole.toString().split(System.lineSeparator());

        assertThat(log)
            .containsExactly("Starring:"
                , "Skyler White"
                , "Jesse Pinkman"
                , "Walter White"
                , "Saul Goodman"
                , "The end!");
    }

}
