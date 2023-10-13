package rx3.operators;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static pluralsight.rxjava.observable.util.ThreadUtils.sleep;

/**
 * Here we're Using merge operator to merge Two or more or list of Observables
 * <p>
 */

public class Ob4Merge {

    public static void main(String[] args) {
        exMerge();
        exMergeArray();
        exMergeWith();
        exMergeInfinite();
    }

    /**
     * Uses the static merge function to merge Observables
     * This function can take at most 4 Observables
     */
    private static void exMerge() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);

        Observable.merge(sixToTen, oneToFive)
                .subscribe(System.out::println);
    }

    /**
     * Uses the static mergeArray function to merge unlimited Observables, as it takes vararg
     */
    private static void exMergeArray() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
        Observable<Integer> elevenToFifteen = Observable.just(11, 12, 13, 14, 15);
        Observable<Integer> sixteenToTwenty = Observable.just(16, 17, 18, 19, 20);
        Observable<Integer> twentyOneToTwentyFive = Observable.just(21, 22, 23, 24, 25);

        Observable.mergeArray(oneToFive,
                        sixToTen,
                        elevenToFifteen,
                        sixteenToTwenty,
                        twentyOneToTwentyFive)
                .subscribe(System.out::println);

        // similarly, this is also ok
        List<Observable<Integer>> observableList =
                List.of(oneToFive,
                        sixToTen,
                        elevenToFifteen,
                        sixteenToTwenty,
                        twentyOneToTwentyFive);

        Observable.merge(observableList)
                .subscribe(System.out::println);


    }

    /**
     * All Observables has the mergeWith function, to easily merge it with another Observable
     * We can't merge with more than one Observable in this case
     */
    private static void exMergeWith() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);

        oneToFive.mergeWith(sixToTen)
                .subscribe(System.out::println);
    }

    /**
     * This shows an implementation of the merge function with infinite Observables
     * As interval emits data as given time
     */
    private static void exMergeInfinite() {
        Observable<String> infinite1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(item -> "From infinite1: " + item);

        Observable<String> infinite2 = Observable.interval(2, TimeUnit.SECONDS)
                .map(item -> "From infinite2: " + item);


        infinite1.mergeWith(infinite2)
                .subscribe(System.out::println);

        sleep(6050);
    }
}