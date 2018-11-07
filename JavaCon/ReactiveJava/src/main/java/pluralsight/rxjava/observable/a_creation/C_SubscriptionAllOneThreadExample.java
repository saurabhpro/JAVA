/*
 * Copyright (c) 2018 Saurabh Kumar
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
						i -> {
							// Println the name of the current thread on entry and exit so that we
							// can see a few interesting pieces of information...
							System.out.println("\nonNext thread entr: " + ThreadUtils.currentThreadName());
							System.out.println(i);
							System.out.println("onNext thread exit: " + ThreadUtils.currentThreadName());
						},

						// onError function
						Throwable::printStackTrace,

						// onCompleted function
						() -> System.out.println("\nonCompleted()")
				);

		System.exit(0);
	}
}
