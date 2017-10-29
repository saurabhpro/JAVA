/*
 * Copyright 2017 Saurabh Kumar 29/10/17 1:14 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.rxjava.observable.a_creation;

import io.reactivex.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

public class A_SimpleCreationExamples {

	public static void main(String[] args) {
		Observable<Integer> observable = null;

		System.out.println("---------------------------------------------");
		System.out.println("Observable a_creation from a single value");
		System.out.println("---------------------------------------------");
		observable = Observable.fromArray(42);
		observable.subscribe(System.out::println);

		System.out.println("---------------------------------------------");
		System.out.println("Observable a_creation from an Iterable");
		System.out.println("---------------------------------------------");
		observable = Observable.fromIterable(DataGenerator.generateFibonacciList());
		observable.subscribe(System.out::println);

		System.out.println("---------------------------------------------");
		System.out.println("Observable a_creation from an Array");
		System.out.println("---------------------------------------------");
		observable = Observable.fromArray(DataGenerator.generateFibonacciArray());
		observable.subscribe(System.out::println);

		System.exit(0);
	}
}
