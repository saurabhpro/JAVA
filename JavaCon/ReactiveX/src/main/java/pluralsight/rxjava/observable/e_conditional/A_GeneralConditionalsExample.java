/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.e_conditional;


import io.reactivex.rxjava3.core.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

public class A_GeneralConditionalsExample {

    public static void main(String[] args) {

        // defaultIfEmpty example - We create an empty observable
        // and then apply "defaultIfEmpty" and set the default to "Hello World".
        // Since the observable is empty, "Hello World" will be emitted as
        // the only event.
        Observable.empty()
                .defaultIfEmpty("Hello World")
                .subscribe(System.out::println);

        System.out.println();

        // defaultIfEmpty example  2 - We create an non-empty observable
        // and then apply "defaultIfEmpty" and set the default to "Hello World".
        // Since the observable is not empty, the list items will be emitted.
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .defaultIfEmpty("Hello World")
                .firstOrError() // we just want to show that it isn't Hello World...
                .subscribe(System.out::println);

        System.out.println();

        Observable.fromIterable(DataGenerator.generateFibonacciList())
                .skipWhile((i) -> i < 8)
                .subscribe(System.out::println);

        System.out.println();

        Observable.fromIterable(DataGenerator.generateFibonacciList())
                .takeWhile((i) -> i < 8)
                .subscribe(System.out::println);

        System.out.println();

        Observable.fromIterable(DataGenerator.generateFibonacciList())
                .takeWhile((index) -> index < 3)
                .subscribe(System.out::println);

        System.out.println();

        System.exit(0);

    }

}
