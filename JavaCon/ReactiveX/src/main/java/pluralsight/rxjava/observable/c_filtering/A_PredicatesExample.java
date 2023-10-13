/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.c_filtering;

import io.reactivex.rxjava3.core.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

public class A_PredicatesExample {

    public static void main(String[] args) {

        // Create an observable from a big list of integers (0...199)
        // ...use a predicate (filter) to only return numbers divisible by 3 and
        // less than 20...
        Observable.fromIterable(DataGenerator.generateBigIntegerList())
                .filter(i -> ((i % 3 == 0) && (i < 20)))
                .subscribe(System.out::println);

        System.exit(0);
    }
}
