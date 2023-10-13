/*
 * Copyright (c) 2011-2017 Pivotal Software Inc, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rxcore.pivotal.literx;

import org.junit.jupiter.api.Test;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static rxcore.pivotal.literx.domain.User.JESSE;
import static rxcore.pivotal.literx.domain.User.SAUL;
import static rxcore.pivotal.literx.domain.User.SKYLER;
import static rxcore.pivotal.literx.domain.User.WALTER;

/**
 * Learn how to deal with errors.
 *
 * @author Sebastien Deleuze
 * @see Exceptions#propagate(Throwable)
 */
class Part07ErrorsTest {

    final Part07Errors workshop = new Part07Errors();

//========================================================================================

    @Test
    void monoWithValueInsteadOfError() {
        var mono = workshop.betterCallSaulForBogusMono(Mono.error(new IllegalStateException()));
        StepVerifier.create(mono)
            .expectNext(SAUL)
            .verifyComplete();

        mono = workshop.betterCallSaulForBogusMono(Mono.just(SKYLER));
        StepVerifier.create(mono)
            .expectNext(SKYLER)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void fluxWithValueInsteadOfError() {
        var flux = workshop.betterCallSaulAndJesseForBogusFlux(Flux.error(new IllegalStateException()));
        StepVerifier.create(flux)
            .expectNext(SAUL, JESSE)
            .verifyComplete();

        flux = workshop.betterCallSaulAndJesseForBogusFlux(Flux.just(SKYLER, WALTER));
        StepVerifier.create(flux)
            .expectNext(SKYLER, WALTER)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void handleCheckedExceptions() {
        var flux = workshop.capitalizeMany(Flux.just(SAUL, JESSE));

        StepVerifier.create(flux)
            .verifyError(Part07Errors.GetOutOfHereException.class);
    }

}
