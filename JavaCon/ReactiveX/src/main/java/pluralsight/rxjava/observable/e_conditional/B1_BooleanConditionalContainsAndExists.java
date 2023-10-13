/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.e_conditional;


import io.reactivex.rxjava3.core.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

/**
 * contains(thisValue)
 * Returns a Single that emits a Boolean that indicates whether the source ObservableSource emitted a
 * specified item.
 */
public class B1_BooleanConditionalContainsAndExists {

    public static void main(String[] args) {

        // Create an observable from out big list of integers
        Observable.fromIterable(DataGenerator.generateBigIntegerList())
                // Test to see if the list contains the number 100
                .contains(100)
                // Subscribe to the boolean result.
                .subscribe((b) -> {
                    if (b) {
                        System.out.println("contains evaluated to true - the number 100 is present");
                    } else {
                        System.out.println("contains evaluated to false - the number 100 is not present");
                    }
                });

        System.out.println();

        // Create an observable from out big list of integers
        Observable.fromIterable(DataGenerator.generateBigIntegerList())
                // Test to see if the list contains the number 100
                .any((i) -> i == 100)
                // Subscribe to the boolean result.
                .subscribe(b -> {
                    if (b) {
                        System.out.println("exists evaluated to true - the number 100 exists in the list");
                    } else {
                        System.out.println("exists evaluated to false - the number 100 does not exist in the list");
                    }
                });

        System.out.println();

        System.exit(0);
    }
}
