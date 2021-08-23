package rx3.operators;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static pluralsight.rxjava.observable.util.DataGenerator.LINE;
import static pluralsight.rxjava.observable.util.ThreadUtils.sleep;

/**
 * We've started our RxJava Operator's series with map() and filter()
 * Here you can check how map() and filter() works individually
 * and also with each other by chaining multiple operators
 */

public class Ob5Operators {
    public static final Logger LOG = LoggerFactory.getLogger(Ob5Operators.class);

    public static void main(String[] args) {
        mapAndFilter();

        takeOperator();
        takeWithInterval();
        takeWhileOperator();
        skipOperator();
        skipWhileOperator();

        distinctOperator();
        distinctWithKeySelector();
        distinctUntilChangedOperator();

        useDefaultIfEmpty();
        useSwitchIfEmpty();
    }

    /**
     * Uses the map() operator to transform the value in between,
     * before it reaches to the Observer
     * <p>
     * Uses the filter() operator to filter out the value in between,
     * which doesn't meet the logic specified in filter,
     * and filter() may not emit no item if it no item match that criteria
     * <p>
     * Combines the map() and filter() operator together
     * and as map() and filter() both are nothing but an Observable
     * and also works like an Observer, so we can chain them,
     * but the order of operation does matter here.
     * Here filter() will kicks in first and map() will work on the filtered emission,
     * and not the whole emission in general
     */
    private static void mapAndFilter() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable
                .filter(item -> item % 2 == 0)
                .map(item -> item * 2)
                .subscribe(System.out::println);
    }

    /**
     * Used take(2) here, which emits only first 2 items and then complete
     */
    private static void takeOperator() {
        LOG.info(LINE);
        Observable.just(1, 2, 3, 4, 5)
                .take(2)
                .subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }

    /**
     * Used take(2) but with interval here, which emits items for the specified time interval only
     */
    private static void takeWithInterval() {
        LOG.info(LINE);
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS)  // only take until 2 seconds (so if 300ms -> print 0 1 2 3 ... 5!
                .subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));

        sleep(5000);
    }

    /**
     * This takeWhile() is like combination of filter and take,
     * the only difference is filter goes through all the items to check if the logic is true
     * whereas takeWhile() keep emitting only some logic is true
     * and it completes once it gets logic as false
     */
    private static void takeWhileOperator() {
        LOG.info(LINE);
        Observable.just(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
                .takeWhile(item -> item <= 3)
                .subscribe(System.out::println);
    }

    /**
     * skip(2) is just the opposite of take(2)
     * it will skip first values and emit remaining ones
     */
    private static void skipOperator() {
        LOG.info(LINE);
        Observable.just(1, 2, 3, 4, 5)
                .skip(2)
                .subscribe(System.out::println);
    }

    /**
     * skipWhile() is little is like combination of filter and skip,
     * the only difference is filter goes through all the items to check if the logic is true
     * whereas skipWhile() keep skipping items only if some logic true
     * and once the logic is false it emits remaining items without checking
     */
    private static void skipWhileOperator() {
        LOG.info(LINE);
        Observable.just(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
                .skipWhile(item -> item <= 3)   // it will allow the second 1 2
                .subscribe(System.out::println);
    }

    /**
     * Used the distinct() to get the unique emission
     */
    private static void distinctOperator() {
        LOG.info(LINE);
        Observable.just(1, 1, 2, 2, 3, 3, 4, 5, 1, 2)
                .distinct()
                .subscribe(System.out::println);
    }

    /**
     * Used the distinct based on the item's property to distinguish emission
     */
    private static void distinctWithKeySelector() {
        LOG.info(LINE);
        Observable.just("foo", "fool", "super", "foss", "foil")
                .distinct(String::length)
                .subscribe(System.out::println);
    }

    /**
     * Used distinctUntilChanged() to avoid consecutive duplicate items one after another
     */
    private static void distinctUntilChangedOperator() {
        LOG.info(LINE);
        Observable.just(1, 1, 2, 2, 3, 3, 4, 5, 1, 2)
                .distinctUntilChanged() // print distinct by only looking at adjacent value
                .subscribe(System.out::println);
    }

    /**
     * Used defaultIfEmpty() operator so the observer will emit at least a default value
     * if the emission gets empty
     */
    private static void useDefaultIfEmpty() {
        LOG.info(LINE);

        Observable.just(1, 2, 3, 4, 5)
                .filter(item -> item > 10)
                .defaultIfEmpty(100)
                .subscribe(System.out::println);
    }

    /**
     * This will switch to some alternative Observable Source
     * if the emission gets empty
     */
    private static void useSwitchIfEmpty() {
        LOG.info(LINE);

        Observable.just(1, 2, 3, 4, 5)
                .filter(item -> item > 10)
                .switchIfEmpty(Observable.just(6, 7, 8, 9, 10))
                .subscribe(System.out::println);
    }
}