/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.c_filtering;


import io.reactivex.rxjava3.core.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

public class C_PositionalExampleFirstAndLastWithPredicate {

    public static void main(String[] args) {

        // Emit the greek alphabet, but only the first letter
        // that matches our predicate
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .filter((letter) -> letter.equals("Beta"))
                .firstElement()
                .subscribe((letter) -> {
                    System.out.println(letter);
                });

        System.out.println();

        // Emit the greek alphabet, but only the last letter
        // that matches our predicate
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .filter((letter) -> letter.equals("Gamma"))
                .takeLast(1)
                .subscribe((letter) -> {
                    System.out.println(letter);
                });

        System.out.println();


        System.exit(0);
    }
}
