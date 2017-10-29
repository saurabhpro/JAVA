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
import io.reactivex.schedulers.Schedulers;
import pluralsight.rxjava.observable.util.DataGenerator;
import pluralsight.rxjava.observable.util.ThreadUtils;

import java.util.List;

public class D_SubscribeOnThreadExample {

	public static void main(String[] args) {

		// Create and sync on an object that we will use to make sure we don't
		// hit the System.exit(0) call before our threads have had a chance
		// to complete.
		Object waitMonitor = new Object();

		synchronized (waitMonitor) {

			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("Creating an Observable that specifies an subscribeOn, but not an observeOn Scheduler");
			System.out.println("driving thread: " + ThreadUtils.currentThreadName());
			System.out.println("---------------------------------------------------------------------------------------");

			// Create my favorite list...
			List<Integer> emitList = DataGenerator.generateFibonacciList();

			// ...and wrap it in an Observable
			Observable<Integer> observable = Observable.fromIterable(emitList);

			// dot chain call on the observable list to...
			// Just do the simplest thing for the sake of example.
			observable
					// make sure that the subscriber driver code executes on a new thread...
					.subscribeOn(Schedulers.newThread())
					.subscribe(
							// onNext function
							(i) -> {
								System.out.println("onNext thread entr: " + ThreadUtils.currentThreadName());
								System.out.println(i);
								System.out.println("onNext thread exit: " + ThreadUtils.currentThreadName());
							},
							// onError function
							Throwable::printStackTrace,
							// onComplete
							() -> {
								System.out.println("onCompleted()");

								// Since we have completed...we sync on the waitMonitor
								// and then call notify to wake up the "main" thread.
								synchronized (waitMonitor) {
									waitMonitor.notify();
								}
							}
					);

			// Wait until the onCompleted method wakes us up.
			ThreadUtils.wait(waitMonitor);
		}

		System.exit(0);
	}
}
