package rx3.operators;

import io.reactivex.rxjava3.core.Observable;

/**
 * Here we're Using concat operator to merge Two or more or list of Observables
 * The Observable.concat() factory is the concatenation equivalent to
 * Observable.merge(). It will combine the emitted values of multiple observables, but will
 * fire each one sequentially and only move to the next after onComplete() is called
 * <p>
 */

public class Ob5Concat {

    public static void main(String[] args) {
        exConcat();
        exConcatWith();
        exConcatMap();
    }

    /**
     * Uses the static concat function to merge Observables
     * This function can take at most 4 Observables
     */
    private static void exConcat() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);

        Observable.concat(sixToTen, oneToFive)
                .subscribe(System.out::println);
    }

    /**
     * All Observables has the mergeWith function, to easily merge it with another Observable
     * We can't merge with more than one Observable in this case
     */
    private static void exConcatWith() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);

        oneToFive.concatWith(sixToTen)
                .subscribe(System.out::println);
    }

    private static void exConcatMap() {
        Observable<String> source = Observable.just("Alpha", "Beta", "Gamma");

        source.concatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(System.out::println);
    }
}