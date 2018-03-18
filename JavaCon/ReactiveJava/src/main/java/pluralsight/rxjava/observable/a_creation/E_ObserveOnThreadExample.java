/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.a_creation;


import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import pluralsight.rxjava.observable.util.DataGenerator;
import pluralsight.rxjava.observable.util.ThreadUtils;

import java.util.List;

public class E_ObserveOnThreadExample {

	public static void main(String[] args) {

		// Create and sync on an object that we will use to make sure we don't
		// hit the System.exit(0) call before our threads have had a chance
		// to complete.
		Object waitMonitor = new Object();
		synchronized (waitMonitor) {

			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("Creating an Observable that does not specify a subscribeOn or an observeOn Scheduler");
			System.out.println("driving thread: " + ThreadUtils.currentThreadName());
			System.out.println("---------------------------------------------------------------------------------------");

			// Create my favorite list...again...
			List<Integer> emitList = DataGenerator.generateFibonacciList();

			// ...and wrap it in an Observable
			Observable<Integer> observable = Observable.fromIterable(emitList);

			// Dot chain on the observable...
			observable
					// tell the observable to use the io scheduler...I use it instead
					// of the computation scheduler in case you run this example on a
					// single core system...I know the io scheduler will generate a more
					// interesting example.
					.observeOn(Schedulers.io())
					.subscribe(
							// onNext
							(i) -> {
								System.out.println("onNext thread entr: " + ThreadUtils.currentThreadName());
								System.out.println(i);
								System.out.println("onNext thread exit: " + ThreadUtils.currentThreadName());
							},
							// onError
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
