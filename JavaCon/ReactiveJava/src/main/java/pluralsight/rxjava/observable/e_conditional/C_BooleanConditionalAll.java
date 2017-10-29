/*
 * Copyright 2017 Saurabh Kumar 29/10/17 3:07 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
