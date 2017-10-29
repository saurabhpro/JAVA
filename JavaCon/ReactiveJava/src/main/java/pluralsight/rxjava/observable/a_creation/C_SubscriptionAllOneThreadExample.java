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
import pluralsight.rxjava.observable.util.ThreadUtils;

import java.util.List;

public class C_SubscriptionAllOneThreadExample {

	public static void main(String[] args) {

		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Creating an Observable that does not specify a subscribeOn or an observeOn Scheduler");
		System.out.println("driving thread: " + ThreadUtils.currentThreadName());
		System.out.println("---------------------------------------------------------------------------------------");

		// Get the list of integers that I seem to like best...
		List<Integer> intList = DataGenerator.generateFibonacciList();

		// Wrap the list in an Observable
		Observable<Integer> observable = Observable.fromIterable(intList);

		// Subscribe...
		// Should we get an error...just do the simplest thing.
		observable
				.subscribe(
						// onNext function
						(i) -> {
							// Println the name of the current thread on entry and exit so that we
							// can see a few interesting pieces of information...
							System.out.println("onNext thread entr: " + ThreadUtils.currentThreadName());
							System.out.println(i);
							System.out.println("onNext thread exit: " + ThreadUtils.currentThreadName());
						},
						// onError function
						Throwable::printStackTrace,
						// onCompleted function
						() -> {
							System.out.println("onCompleted()");
						}
				);

		System.exit(0);
	}
}
