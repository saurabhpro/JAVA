package rx3.basics;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static pluralsight.rxjava.observable.util.DataGenerator.LINE;

/**
 * Here we've 4 error handling operators to showcase some techniques to handle errors in RxJava
 */
public class Ob6Exceptions {
    private static final Logger LOG = LoggerFactory.getLogger(Ob6Exceptions.class);

    public static void main(String[] args) {
        exDoOnError();
        exOnErrorResumeNext();
        exOnErrorReturn();
        exOnErrorReturnItem();
    }

    /**
     * The error goes to the doOnError lambda on the chain first, so we can handle it
     */
    private static void exDoOnError() {
        LOG.info(LINE);
        Observable.error(new RuntimeException("This is an example error"))
                .doOnError(error -> LOG.error("Error: {}", error.getMessage()));    // nothing printed by published

        LOG.info(LINE);
        Observable.error(new RuntimeException("This is an example error"))
                .doOnError(error -> LOG.error("Error: {}", error.getMessage())) //first do this on error post subscribe
                .subscribe(
                        x -> LOG.info("{}", x),
                        error -> LOG.error("Subscribed Error: {}", error.getMessage()) // then do this on subscribe
                );
    }

    /**
     * Whenever an error is found on the chain, it goes to the onErrorResumeNext
     * As this takes another Observable, the subscriber switch to that Observable
     * to skip the error
     */
    private static void exOnErrorResumeNext() {
        LOG.info(LINE);
        Observable.error(new RuntimeException("This is an example error"))
                .onErrorResumeNext(e -> {
                    LOG.error("My life shouldn't affect the next generation. {}", e.getLocalizedMessage());
                    return Observable.just(1, 2, 3, 4, 5);
                })
                .subscribe(
                        x -> LOG.info("{}", x),
                        error -> LOG.error("Subscribed Error: {}", error.getMessage()),
                        () -> LOG.info("Completed"));
    }

    /**
     * We can return specific values based on the error type
     * As when we get the error it goes to the onErrorReturn lambda
     */
    private static void exOnErrorReturn() {
        LOG.info(LINE);
        Observable.error(new Exception("This is an example error"))
                .onErrorReturn(error -> {
                    if (error instanceof IOException) {
                        return 0;
                    } else {
                        throw new RuntimeException("This is an exception");
                    }
                })
                .subscribe(
                        x -> LOG.info("{}", x),
                        error -> LOG.error("Subscribed Error: {}", error.getMessage()),
                        () -> LOG.info("Completed"));
    }

    /**
     * We can pass an alternative for the subscriber below the chain
     * Whenever error encounters it gives that specific alternative
     */
    private static void exOnErrorReturnItem() {
        LOG.info(LINE);
        Observable.error(new IOException("This is an example error"))
                .onErrorReturnItem(1)
                .subscribe(
                        x -> LOG.info("{}", x),
                        error -> LOG.error("Subscribed Error: {}", error.getMessage()),
                        () -> LOG.info("Completed"));
    }

}