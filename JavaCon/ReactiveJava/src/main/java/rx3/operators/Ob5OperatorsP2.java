package rx3.operators;

import io.reactivex.rxjava3.core.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;

import static pluralsight.rxjava.observable.util.DataGenerator.LINE;

public class Ob5OperatorsP2 {
    public static final Logger LOG = LoggerFactory.getLogger(Ob5OperatorsP2.class);

    public static void main(String[] args) {
        useRepeat();
        useScan();
        useScanWithInitialValue();

        useSorted();
        useSortedOnNonComparator();
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
     * This uses scan operator to print the sum of the previously emitted item and current one that is going to emit
     */
    private static void useScan() {
        LOG.info(LINE);

        Observable.just(1, 2, 3, 4, 5)
                .scan(Integer::sum)
                .subscribe(System.out::println);
    }

    /**
     * This uses scan operator print the sum of the previously emitted item and current one that is going to emit,
     * but this also takes the initial emission into consideration by specifying an initial value
     */
    private static void useScanWithInitialValue() {
        LOG.info(LINE);

        Observable.just(1, 2, 3, 4, 5)
                .scan(10, (accumulator, next) -> accumulator + next)
                .subscribe(System.out::println);
    }

    /**
     * This used sorted operator to sort the operator
     */
    private static void useSorted() {
        LOG.info(LINE);

        Observable.just(3, 5, 2, 4, 1)
                .sorted()
                .subscribe(System.out::println);
    }


    /**
     * This used sorted operator along with Integer's compare function to
     * sort the emission based on their length
     */
    private static void useSortedOnNonComparator() {
        LOG.info(LINE);

        Observable.just("foo", "john", "bar")
                .sorted(Comparator.comparingInt(String::length))
                .subscribe(System.out::println);
    }
}
