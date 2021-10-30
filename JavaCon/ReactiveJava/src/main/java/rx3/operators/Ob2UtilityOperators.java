package rx3.operators;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static pluralsight.rxjava.observable.util.DataGenerator.LINE;
import static pluralsight.rxjava.observable.util.ThreadUtils.sleep;

public class Ob2UtilityOperators {
    public static final Logger LOG = LoggerFactory.getLogger(Ob2UtilityOperators.class);

    public static void main(String[] args) {
        useRepeat();

        delayError();

        timestamp();
    }

    /**
     * This used repeat operator to specify how many times emission witll repeat
     */
    private static void useRepeat() {
        LOG.info(LINE);

        Observable.just(1, 2, 3, 4, 5)
                .repeat(3)
                .subscribe(System.out::println);
    }

    /**
     * 'delay' operator doesn't add any delay before emitting error
     * This means the error is immediately emitted to it's subscribers by default
     * To delay the emission of error we need to pass delayError parameter as true
     */
    private static void delayError() {
        LOG.info(LINE);

        Observable.error(new Exception("Error"))
                .delay(3, TimeUnit.SECONDS, true)
                .subscribe(System.out::println,
                        error -> System.out.println(error.getLocalizedMessage()),
                        () -> System.out.println("Completed"));
        sleep(5000);
    }

    private static void timestamp() {
        LOG.info(LINE);

        Observable.just("One", "Two", "Three")
                .timestamp(TimeUnit.SECONDS)
                .subscribe(i -> LOG.info("Received: %d %s %s".formatted(i.time(), i.unit(), i.value())));
    }
}