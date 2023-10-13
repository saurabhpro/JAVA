/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rxcore.pivotal.literx;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import rxcore.pivotal.literx.domain.User;
import rxcore.pivotal.literx.repository.ReactiveRepository;
import rxcore.pivotal.literx.repository.ReactiveUserRepository;

import static rxcore.pivotal.literx.domain.User.JESSE;
import static rxcore.pivotal.literx.domain.User.SAUL;
import static rxcore.pivotal.literx.domain.User.SKYLER;
import static rxcore.pivotal.literx.domain.User.WALTER;

/**
 * Learn how to adapt from/to RxJava 3 Observable/Single/Flowable and Java 8+ CompletableFuture.
 * <p>
 * Mono and Flux already implements Reactive Streams interfaces so they are natively
 * Reactive Streams compliant + there are {@link Mono#from(Publisher)} and {@link Flux#from(Publisher)}
 * factory methods.
 * <p>
 * For RxJava 3, you should not use Reactor Adapter but only RxJava 3 and Reactor Core.
 *
 * @author Sebastien Deleuze
 */
class Part09AdaptTest {

    final Part09Adapt workshop = new Part09Adapt();
    final ReactiveRepository<User> repository = new ReactiveUserRepository();

//========================================================================================

    @Test
    void adaptToFlowable() {
        var flux = repository.findAll();
        var flowable = workshop.fromFluxToFlowable(flux);
        StepVerifier.create(workshop.fromFlowableToFlux(flowable))
            .expectNext(SKYLER, JESSE, WALTER, SAUL)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void adaptToObservable() {
        var flux = repository.findAll();
        var observable = workshop.fromFluxToObservable(flux);
        StepVerifier.create(workshop.fromObservableToFlux(observable))
            .expectNext(SKYLER, JESSE, WALTER, SAUL)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void adaptToSingle() {
        var mono = repository.findFirst();
        var single = workshop.fromMonoToSingle(mono);
        StepVerifier.create(workshop.fromSingleToMono(single))
            .expectNext(SKYLER)
            .verifyComplete();
    }

//========================================================================================

    @Test
    void adaptToCompletableFuture() {
        var mono = repository.findFirst();
        var future = workshop.fromMonoToCompletableFuture(mono);
        StepVerifier.create(workshop.fromCompletableFutureToMono(future))
            .expectNext(SKYLER)
            .verifyComplete();
    }

}
