/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.d_transformation;

import io.reactivex.rxjava3.core.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

public class A_MapExample {

    public static void main(String[] args) {

        // Simple map example...transform every greek letter string
        // into upper case.
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .map(String::toUpperCase)
                .subscribe(System.out::println);

        System.out.println("--------------------------------------------------");

        // flatMap -> Each greek letter is emitted as all upper and
        // all lower case...doubling the output.  One item in the origin
        // list generates multiple items.
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .flatMap((letterString) -> {

                    String[] returnStrings = {letterString.toUpperCase(), letterString.toLowerCase()};

                    return Observable.fromArray(returnStrings);
                })
                .subscribe(System.out::println);

        System.exit(0);
    }
}
