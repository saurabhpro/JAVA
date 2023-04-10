package rxcore.pivotal.literx;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rxcore.pivotal.literx.domain.User;

import java.util.List;

import static rxcore.pivotal.literx.domain.User.SKYLER;

/**
 * Learn how to use various other operators.
 *
 * @author Sebastien Deleuze
 */
public class Part08OtherOperations {

//========================================================================================

    // Create a Flux of user from Flux of userName, firstName and lastName.
    Flux<User> userFluxFromStringFlux(Flux<String> usernameFlux,
                                      Flux<String> firstnameFlux,
                                      Flux<String> lastnameFlux) {
        return Flux
            .zip(usernameFlux, firstnameFlux, lastnameFlux)
            .map(tuple -> new User(tuple.getT1(), tuple.getT2(), tuple.getT3()));
    }

//========================================================================================

    // Return the mono which returns its value faster
    Mono<User> useFastestMono(Mono<User> mono1, Mono<User> mono2) {
        return Mono.firstWithValue(mono1, mono2);
    }

//========================================================================================

    // Return the flux which returns the first value faster
    Flux<User> useFastestFlux(Flux<User> flux1, Flux<User> flux2) {
        return Flux.firstWithValue(flux1, flux2);
    }

//========================================================================================

    // Convert the input Flux<User> to a Mono<Void> that represents the complete signal of the flux
    Mono<Void> fluxCompletion(Flux<User> flux) {
        return flux.then();
    }

//========================================================================================

    // Return a valid Mono of user for null input and non null input user (hint: Reactive Streams do not accept null values)
    Mono<User> nullAwareUserToMono(User user) {
        return Mono.justOrEmpty(user);
    }

//========================================================================================

    // Return the same mono passed as input parameter, expect that it will emit User.SKYLER when empty
    Mono<User> emptyToSkyler(Mono<User> mono) {
        return mono.defaultIfEmpty(SKYLER);
    }

//========================================================================================

    // Convert the input Flux<User> to a Mono<List<User>> containing list of collected flux values
    Mono<List<User>> fluxCollection(Flux<User> flux) {
        return flux.collectList();
    }

}
