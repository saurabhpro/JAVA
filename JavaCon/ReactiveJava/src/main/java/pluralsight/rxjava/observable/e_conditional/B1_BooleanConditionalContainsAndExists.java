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
