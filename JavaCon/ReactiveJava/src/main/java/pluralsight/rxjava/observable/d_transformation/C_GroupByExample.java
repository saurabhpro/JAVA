/*
 * Copyright 2017 Saurabh Kumar 29/10/17 6:42 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.rxjava.observable.d_transformation;

import io.reactivex.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

import java.util.ArrayList;

public class C_GroupByExample {

	public static void main(String[] args) {

		// Create an observable on top of our list of 0...199 integers
		Observable.fromIterable(DataGenerator.generateBigIntegerList())
				// Group based on odd or even using a string literal
				// for the key
				.groupBy((i) -> 0 == (i % 2) ? "EVEN" : "ODD")
				// Subscribe to the Observable< GroupedObservable<String,Integer> >
				.subscribe((groupList) -> {

					// For each group, spit out the key
					System.out.println("Key: " + groupList.getKey() + " ------------------------");

					// And subscribe to the items in the list...print them
					// out with their key.
					groupList.subscribe((x) -> {
						System.out.println(groupList.getKey() + ": " + x);
					});
				});

		// Interesting!  Odds and evens still come out mixed!  But notice that
		// the keys are correct.  We must remember that once we are inside
		// a lambda expression or closure that we are simply declaring what we
		// want to happen.  The order that things are called may not be what
		// they seem.


		// For the next example, create a list of even and odd numbers
		final ArrayList<Integer> evenList = new ArrayList<>();
		final ArrayList<Integer> oddList = new ArrayList<>();

		// We do the same thing again...
		Observable.fromIterable(DataGenerator.generateBigIntegerList())
				.groupBy((i) -> 0 == (i % 2) ? "EVEN" : "ODD")
				.subscribe((groupList) -> {

					groupList.subscribe((x) -> {

						// ...but this time, we add to our lists so that we
						// can show that things got grouped correctly more
						// easily.
						if (groupList.getKey().equals("EVEN")) {
							evenList.add(x);
						} else {
							oddList.add(x);
						}
					});

				});

		System.out.println();
		System.out.println();

		// Dump the even list
		System.out.println("even list -------------------------------------");
		evenList.forEach(System.out::println);

		// Dump the odd list
		System.out.println("odd list -------------------------------------");
		oddList.forEach(System.out::println);

		System.exit(0);
	}
}
