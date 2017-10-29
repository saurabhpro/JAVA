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

public class A_GeneralConditionalsExample {

	public static void main(String[] args) {

		// defaultIfEmpty example - We create an empty observable
		// and then apply "defaultIfEmpty" and set the default to "Hello World".
		// Since the observable is empty, "Hello World" will be emitted as
		// the only event.
		Observable.empty()
				.defaultIfEmpty("Hello World")
				.subscribe(System.out::println);

		System.out.println();

		// defaultIfEmpty example  2 - We create an non-empty observable
		// and then apply "defaultIfEmpty" and set the default to "Hello World".
		// Since the observable is not empty, the list items will be emitted.
		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.defaultIfEmpty("Hello World")
				.firstOrError() // we just want to show that it isn't Hello World...
				.subscribe(System.out::println);

		System.out.println();

		Observable.fromIterable(DataGenerator.generateFibonacciList())
				.skipWhile((i) -> i < 8)
				.subscribe(System.out::println);

		System.out.println();

		Observable.fromIterable(DataGenerator.generateFibonacciList())
				.takeWhile((i) -> i < 8)
				.subscribe(System.out::println);

		System.out.println();

		Observable.fromIterable(DataGenerator.generateFibonacciList())
				.takeWhile((index) -> index < 3)
				.subscribe(System.out::println);

		System.out.println();

		System.exit(0);

	}

}
