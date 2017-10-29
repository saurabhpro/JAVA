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
