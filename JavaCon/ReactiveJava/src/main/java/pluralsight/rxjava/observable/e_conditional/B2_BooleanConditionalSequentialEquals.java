/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.e_conditional;

import io.reactivex.rxjava3.core.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

/**
 * sequenceEqual(a,b)
 * Returns a Single that emits a Boolean value that indicates whether two ObservableSource sequences are the
 * same by comparing the items emitted by each ObservableSource pairwise.
 */
public class B2_BooleanConditionalSequentialEquals {

    public static void main(String[] args) {

        // Create two equivalent observables...
        Observable<Integer> compareList = Observable.fromIterable(DataGenerator.generateBigIntegerList());
        Observable<Integer> compareList2 = Observable.fromIterable(DataGenerator.generateBigIntegerList());


        // See if the sequences are equals
        Observable.sequenceEqual(compareList, compareList2)
                // Subscribe to the boolean result.
                .subscribe((b) -> {
                    if (b) {
                        System.out.println("sequenceEqual is true - both sequences match");
                    } else {
                        System.out.println("sequenceEqual is false - sequences do not match");
                    }
                });

        System.out.println();

        // Create two unequal lists...
        compareList = Observable.fromIterable(DataGenerator.generateBigIntegerList());
        compareList2 = Observable.fromIterable(DataGenerator.generateFibonacciList());

        // See if the sequences are equals
        Observable.sequenceEqual(compareList, compareList2)
                // Subscribe to the boolean result.
                .subscribe((b) -> {
                    if (b) {
                        System.out.println("sequenceEqual is true - both sequences match");
                    } else {
                        System.out.println("sequenceEqual is false - sequences do not match");
                    }
                });


        System.exit(0);
    }
}
