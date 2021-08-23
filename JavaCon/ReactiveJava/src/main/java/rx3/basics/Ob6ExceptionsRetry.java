package rx3.basics;

/* Here we've 2 error handling operators to showcase some techniques to handle errors in RxJava
 * <p>
 */

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import static pluralsight.rxjava.observable.util.DataGenerator.LINE;

public class Ob6ExceptionsRetry {
    private static final Logger LOG = LoggerFactory.getLogger(Ob6ExceptionsRetry.class);

    public static void main(String[] args) {
        //retryWithPredicate();
        exRetry();
        exRetryUntil();
    }

    /**
     * This retry block try to analyze the error and take decision based on the error whether to retry or not
     * based on our logic inside that block
     */
    private static void retryWithPredicate() {
        LOG.info(LINE);
        Observable.error(new IOException("This is an example error "))
                .retry(error -> {
                    if (error instanceof IOException) {
                        System.out.println("retrying");
                        return true;    // will throw into an infinte loop
                    } else {
                        return false;
                    }
                })
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    /**
     * This retry takes the number and tries to retry subscribing and getting the data from the observable again
     */
    private static void exRetry() {
        LOG.info(LINE);
        Observable.error(new Exception("This is an example error"))
                .retry(3)
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    /**
     * retryUntil depends on the boolean that we pass, it keeps retrying until we pass true based on the logic
     */
    private static void exRetryUntil() {
        LOG.info(LINE);

        AtomicInteger atomicInteger = new AtomicInteger();

        Observable.error(new Exception("This is an example error"))
                .doOnError(error -> {
                    System.out.println(atomicInteger.get());
                    atomicInteger.getAndIncrement();
                })
                .retryUntil(() -> {
                    System.out.println("Retrying");
                    return atomicInteger.get() >= 3;
                })
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }
}