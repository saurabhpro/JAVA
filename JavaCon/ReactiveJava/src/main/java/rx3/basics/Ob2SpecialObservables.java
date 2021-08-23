package rx3.basics;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static pluralsight.rxjava.observable.util.DataGenerator.LINE;
import static pluralsight.rxjava.observable.util.ThreadUtils.sleep;

/**
 * We've created Observable using two factory methods i.e., Observable.empty() and Observable.never()
 */

public class Ob2SpecialObservables {
    private static final Logger LOG = LoggerFactory.getLogger(Ob2SpecialObservables.class);
    private static int count = 2;

    public static void main(String[] args) {
        createObservableUsingEmpty();
        createObservableUsingNever();
        createObservableUsingDefer();
        createObservableUsingFromCallable();
        createObservableUsingInterval();
    }

    /***
     * This method returns an expression which is an int
     * @return a dummy expression (int)
     */
    private static int getNumber() {
        LOG.info("Generating Value");
        return 1 / 0;
    }

    /**
     * Creates Observable using the factory method called empty()
     * Which doesn't emit any item to onNext() and only completes immediately
     * So, we get the callback on onComplete()
     */
    private static void createObservableUsingEmpty() {
        Observable<?> observable = Observable.empty();

        observable.subscribe(x -> LOG.info("{}", x), error -> LOG.info("Error 1: {}", error.hashCode()));
        observable.subscribe(x -> LOG.info("{}", x),
                error -> LOG.info("{}", error.getLocalizedMessage()),
                () -> LOG.info("Completed"));
    }

    /**
     * Creates Observable using the factory method called never()
     * Which doesn't emit any item and never completes
     * So, it's Observers are keep waiting until the thread is running
     * Observable.never() is primarily used for testing purposes
     */
    private static void createObservableUsingNever() {
        Observable<?> observable = Observable.never();

        observable.subscribe(x -> LOG.info("{}", x),
                error -> LOG.info("{}", error.getLocalizedMessage()),
                () -> LOG.info("Completed"));

        // Pause the main thread for the hope that it will print something
        sleep(3000);
    }

    /**
     * Defer allows us to run a callable to generate new range with modified count, not the variables are static to
     * allow non-effective final variable to be used inside lambda
     */
    private static void createObservableUsingDefer() {
        LOG.info(LINE);
        // it prints from start up to (start + count - 1)
        final int start = 5;

        var observable = Observable.range(start, count);
        observable.subscribe(item -> LOG.info("Observer 1: {}", item)); // only 5 6
        count = 3;
        observable.subscribe(item -> LOG.info("Observer 2: {}", item)); // only 5 6 - count change is not reffered

        LOG.info(LINE);

        count = 2;
        observable = Observable.defer(() -> {
            System.out.println("New Observable is created with start = " + start + " and count = " + count);
            return Observable.range(start, count);
        });

        observable.subscribe(item -> LOG.info("Observer 1: {}", item)); // only 5 6
        count = 3;
        observable.subscribe(item -> LOG.info("Observer 2: {}", item)); // 5 6 7 - count change used by new range object
    }

    /**
     * We've created Observable using Observable.fromCallable()
     * Which Delegates the item generation just before it reaches to the onNext()
     * So that it doesn't throw exception
     * And instead you can get a callback on your onError()
     */
    private static void createObservableUsingFromCallable() {
        LOG.info(LINE);

        // this is eager calling - we don't go to observer workflow of error
        try {
            Observable.just(getNumber());
        } catch (ArithmeticException e) {
            LOG.error("This didn't go to error workflow", e.fillInStackTrace());
        }

        LOG.info(LINE);
        // lazy calling - any exception from observable will follow its workflow
        var observable = Observable.fromCallable(() -> {
            LOG.info("Calling Method");
            return getNumber();
        });
        observable.subscribe(item -> LOG.info("{}", item),
                error -> LOG.error("An Exception Occurred {}", error.getLocalizedMessage()));
    }

    /**
     * <p>
     * We've created Observable using Observable.interval()
     * - emmit sequential numbers from 0 -> infinity on given interval
     * This factory method is very different compare to our previous factories
     * As it works on a computation thread and emit based on specific interval
     * <p>
     */
    private static void createObservableUsingInterval() {
        LOG.info(LINE);
        var observable = Observable.interval(1, TimeUnit.SECONDS);

        observable.subscribe(item -> LOG.info("Observer 1: {}", item));
        sleep(2000);

        observable.subscribe(item -> LOG.info("Observer 2: {}", item));
        sleep(3000);

        // this is a cold obervable as interval creates new instance for each observer
    }


}