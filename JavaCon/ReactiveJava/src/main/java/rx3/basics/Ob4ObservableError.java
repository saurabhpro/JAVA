package rx3.basics;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * We've created Observable using Observable.error()
 * This factory method only provides exception to their Observers
 * through the onError()
 * This is specifically helpful if we don't want to throw exception directly,
 * so we can handle it gracefully in the onError()
 * <p>
 */
public class Ob4ObservableError {
    private static final Logger LOG = LoggerFactory.getLogger(Ob4ObservableError.class);

    public static void main(String[] args) {
        throwException();
        throwExceptionUsingCallable();
    }

    /**
     * This method uses Observable.error() to pass a new instance of exception directly
     * So their observers get the same exception instance everytime
     */
    private static void throwException() {
        Observable<?> observable = Observable.error(new Exception("An Exception"));
        observable.subscribe(x -> LOG.info("{}", x), error -> LOG.info("Error 1: {}", error.hashCode()));
        observable.subscribe(x -> LOG.info("{}", x), error -> LOG.info("Error 2: {}", error.hashCode()));
    }

    /**
     * This method uses Observable.error() to pass a new Instance of Callable
     * which takes an Exception as it's return type through lambda
     * So their Observers gets a new instance of exception on onError() every time
     */
    private static void throwExceptionUsingCallable() {

        Observable<?> observable = Observable.error(() -> {
            // We're printing this message to show that new instance gets created before
            // publishing the error to their Observers
            LOG.info("New Exception Created");
            return new Exception("An Exception");
        });

        observable.subscribe(x -> LOG.info("{}", x), error -> LOG.info("Error 1: {}", error.hashCode()));
        observable.subscribe(x -> LOG.info("{}", x), error -> LOG.info("Error 2: {}", error.hashCode()));
    }
}