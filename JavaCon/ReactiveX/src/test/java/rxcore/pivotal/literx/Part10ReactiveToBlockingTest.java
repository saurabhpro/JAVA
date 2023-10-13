package rxcore.pivotal.literx;

import org.junit.jupiter.api.Test;
import rxcore.pivotal.literx.domain.User;
import rxcore.pivotal.literx.repository.ReactiveRepository;
import rxcore.pivotal.literx.repository.ReactiveUserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static rxcore.pivotal.literx.domain.User.JESSE;
import static rxcore.pivotal.literx.domain.User.SAUL;
import static rxcore.pivotal.literx.domain.User.SKYLER;
import static rxcore.pivotal.literx.domain.User.WALTER;

/**
 * Learn how to turn Reactive API to blocking one.
 *
 * @author Sebastien Deleuze
 */
class Part10ReactiveToBlockingTest {

    final Part10ReactiveToBlocking workshop = new Part10ReactiveToBlocking();
    final ReactiveRepository<User> repository = new ReactiveUserRepository();

//========================================================================================

    @Test
    void mono() {
        var mono = repository.findFirst();
        var user = workshop.monoToValue(mono);

        assertThat(user).isEqualTo(SKYLER);
    }

//========================================================================================

    @Test
    void flux() {
        var flux = repository.findAll();
        var users = workshop.fluxToValues(flux);

        assertThat(users).containsExactly(SKYLER, JESSE, WALTER, SAUL);
    }

}
