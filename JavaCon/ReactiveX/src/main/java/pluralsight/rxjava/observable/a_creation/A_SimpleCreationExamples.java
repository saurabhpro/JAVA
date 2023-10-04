/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.a_creation;

import io.reactivex.rxjava3.core.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

public class A_SimpleCreationExamples {
    public static final String LINE = "---------------------------------------------";

    public static void main(String[] args) {
        Observable<Integer> observable;


        System.out.println(LINE);
        System.out.println("Observable a_creation from a single value");
        System.out.println(LINE);
        observable = Observable.fromArray(42);
        observable.subscribe(System.out::println);

        System.out.println(LINE);
        System.out.println("Observable a_creation from an Iterable");
        System.out.println(LINE);
        observable = Observable.fromIterable(DataGenerator.generateFibonacciList());
        observable.subscribe(System.out::println);

        System.out.println(LINE);
        System.out.println("Observable a_creation from an Array");
        System.out.println(LINE);
        observable = Observable.fromArray(DataGenerator.generateFibonacciArray());
        observable.subscribe(System.out::println);
    }
}
