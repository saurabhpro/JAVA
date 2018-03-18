/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.e_conditional;

import io.reactivex.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

/**
 * all(Predicate) Returns a Single that emits a Boolean that indicates whether all of the items emitted by the source
 * ObservableSource satisfy a condition.
 */
public class C_BooleanConditionalAll {

	public static void main(String[] args) {

		// Create an observable from out big list of integers
		Observable.fromIterable(DataGenerator.generateBigIntegerList())
				// Test to see if the numbers are greater than 0
				.all((i) -> i >= 0)
				// Subscribe to the boolean result.
				.subscribe((b) -> {
					if (b) {
						System.out.println("all evaluated to true - all numbers >= 0");
					} else {
						System.out.println("all evaluated to false - not all numbers >= 0");
					}
				});

		System.out.println();

		// Create another observable from the big list of integers
		Observable.fromIterable(DataGenerator.generateBigIntegerList())
				// Test to see if all the numbers are even numbers...
				.all((i) -> i % 2 == 0)
				// Subscribe to the resultant boolean
				.subscribe((b) -> {
					if (b) {
						System.out.println("all evaluated to true - all numbers are even");
					} else {
						System.out.println("all evaluated to false - not all numbers are even");
					}
				});

		System.exit(0);
	}
}
