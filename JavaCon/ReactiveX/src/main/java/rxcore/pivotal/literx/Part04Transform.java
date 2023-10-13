package rxcore.pivotal.literx;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rxcore.pivotal.literx.domain.User;

/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 */
public class Part04Transform {

//========================================================================================

    // Capitalize the user userName, firstName and lastName
    Mono<User> capitalizeOne(Mono<User> mono) {
        return mono.map(u ->
            new User(u.userName().toUpperCase(), u.firstName().toUpperCase(), u.lastName().toUpperCase())
        );
    }

//========================================================================================

    // Capitalize the users userName, firstName and lastName
    Flux<User> capitalizeMany(Flux<User> flux) {
        return flux.map(u ->
            new User(u.userName().toUpperCase(), u.firstName().toUpperCase(), u.lastName().toUpperCase())
        );
    }

//========================================================================================

    // Capitalize the users userName, firstName and lastName using #asyncCapitalizeUser
    Flux<User> asyncCapitalizeMany(Flux<User> flux) {
        return flux.flatMap(this::asyncCapitalizeUser);
    }

    private Mono<User> asyncCapitalizeUser(User u) {
        return Mono.just(new User(
            u.userName().toUpperCase(),
            u.firstName().toUpperCase(),
            u.lastName().toUpperCase()));
    }

}
