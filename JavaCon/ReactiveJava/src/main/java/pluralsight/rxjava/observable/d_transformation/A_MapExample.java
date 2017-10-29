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
