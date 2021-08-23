package rx3;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pluralsight.rxjava.observable.util.ThreadUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static pluralsight.rxjava.observable.util.DataGenerator.LINE;

/**
 * <p>
 * In multiple different ways available we've shown three very common and important way
 * to create Observables (Colds Observers)
 * <p>
 */
public class Ob2Creation {
    private static final Logger LOG = LoggerFactory.getLogger(Ob2Creation.class);

    public static void main(String[] args) {
        createObservableWithJust();
        createObservableFromIterable();
        createObservableUsingCreate();

        createObservableWithRange();
    }

    /**
     * In this method we've created an integer observable
     * using Observables static method just()
     * This method converts the items provided to an Observable
     * So later we can subscribe and get the item one by one to take action
     */
    private static void createObservableWithJust() {
        LOG.info(LINE);
        LOG.info("Just");

        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        observable.subscribe(item -> LOG.info("{}", item));
    }

    /**
     * In this method we've created an integer observable
     * using Observables static method fromIterable()
     * This method converts anything which extend or implement iterable, to an observable
     * So later we can subscribe and get the item one by one to take action
     */
    private static void createObservableFromIterable() {
        LOG.info(LINE);
        LOG.info("fromIterable");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Observable<Integer> observable = Observable.fromIterable(list);

        observable.subscribe(item -> LOG.info("{}", item));
    }

    /**
     * In this method we've created an integer observable
     * using Observables static method create()
     * Emitter here is an interface
     * By calling its onNext(), onComplete() and onError() method
     * we can push events to our subscribers
     * So our subscribers can subscribe and get the item one by one to take action
     */
    private static void createObservableUsingCreate() {
        LOG.info(LINE);
        LOG.info("Create");

        Observable<Integer> observable = Observable.create(
                emitter -> {
                    emitter.onNext(1);
                    emitter.onNext(2);
                    emitter.onNext(3);
                    emitter.onNext(4);
                    emitter.onNext(5);

                    // Null values are generally not allowed in 3.x operators and sources
                    // emitter.onNext(null);

                    // emit on complete
                    emitter.onComplete();
                });

        observable.subscribe(
                item -> LOG.info("{}", item),
                error -> LOG.info("There was error: {}", error.getLocalizedMessage()),
                () -> LOG.info("Completed")
        );
    }

    /**
     * We've created Observable using Observable.range(start, count)
     * NOTE: This is not similar to IntSteam.range(start, end)
     */
    private static void createObservableWithRange() {
        LOG.info(LINE);
        LOG.info("Range");

        var observable = Observable.range(0, 10);
        observable.subscribe(item -> LOG.info("{}", item));

        LOG.info(LINE);
        // it prints from start up to (start + count - 1)
        int start = 5;
        int count = 3;
        observable = Observable.range(start, count);

        observable.subscribe(item -> LOG.info("{}", item));

        LOG.info(LINE);
        LOG.info("Interval Range");
        // this is very cool - we emmit the next value after the specified period
        final var longObservable = Observable.intervalRange(start,
                count,
                500,    // initial delay
                1000,       // period
                TimeUnit.MILLISECONDS);

        longObservable.subscribe(item -> LOG.info("{}", item),
                e -> LOG.error(e.getLocalizedMessage()),
                () -> LOG.info("Completed")
        );

        /*
        00:36:40.197 [RxComputationThreadPool-1] INFO rx3.Ob1Creation - 5
        00:36:41.199 [RxComputationThreadPool-1] INFO rx3.Ob1Creation - 6
        00:36:42.194 [RxComputationThreadPool-1] INFO rx3.Ob1Creation - 7
        00:36:42.195 [RxComputationThreadPool-1] INFO rx3.Ob1Creation - Completed
         */

        // this is important Otherwise main thread doesn't wait for all values to be emitted
        ThreadUtils.sleep(3000);
    }
}
