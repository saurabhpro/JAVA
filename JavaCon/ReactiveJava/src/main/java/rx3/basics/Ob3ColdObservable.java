package rx3.basics;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static pluralsight.rxjava.observable.util.ThreadUtils.sleep;

/**
 * We've created Cold Observable using Observable.just()
 * and paused the thread to prove whether it is really Cold-Observable,
 * and we also created Hot Observable
 * by converting a Cold Observable to a Hot Observable using Connectable Observable
 * <p>
 */

public class Ob3ColdObservable {

    private static final Logger LOG = LoggerFactory.getLogger(Ob3ColdObservable.class);

    public static void main(String[] args) {
        createColdObservable();
        createHotAndConnectableObservable();

        // how is this different from java steams - they are not reusable
        Stream<Integer> list = Stream.of(1, 2, 3, 4, 5);
        list.forEach(s -> LOG.info("Stream {}", s));

        // calling it again will return in error
        list.forEach(s -> LOG.info("{}", s));
    }

    /**
     * Creates Cold Observable using Observable.just()
     * Because each and every onNext() gets their separate emission
     */
    private static void createColdObservable() {
        var observable = Observable.just(1, 2, 3, 4, 5);

        observable.subscribe(item -> LOG.info("Observer 1: {}", item));

        pause(1000);

        observable.subscribe(item -> LOG.info("Observer 2: {}", item));
    }

    /**
     * Creates a Hot Observable
     * The moment we call the publish() method on Observable.just()
     * It Converts the Observable to a Connectable Observable
     * <p>
     * Connectable Observable doesn't start its emission right after you subscribe
     * The moment we call connect() method it starts emission
     * Any Observer which subscribes after calling connect() misses emissions
     */
    private static void createHotAndConnectableObservable() {
        var observable = Observable.just(1, 2, 3, 4, 5).publish();

        observable.subscribe(item -> LOG.info("Connectable Observer 1: {}", item));
        observable.subscribe(item -> LOG.info("Connectable Observer 2: {}", item));

        pause(1000);
        // calling connect starts emitting immediately - any order
        observable.connect();

        // if we subscribe now it'll now be emitted - hot observable
        observable.subscribe(item -> LOG.info("Connectable Observer 3: {}", item));
    }

    /**
     * This method sleep the main thread for specified duration
     *
     * @param duration Sleep Duration in Milliseconds
     */
    private static void pause(int duration) {
        LOG.info("\nlets go again!\n");
        sleep(duration);
    }
}