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

import java.util.List;
import java.util.concurrent.FutureTask;

public class B_FutureCreationExample {

	public static void main(String[] args) {

		Observable<List<Integer>> observableFutureList;

		// Create a FutureTask that returns a List<Integer>
		FutureTask<List<Integer>> future = new FutureTask<>(DataGenerator::generateFibonacciList);

		// Construct an observable...note that this only creates the
		// observable wrapper around the future.  The future still needs
		// to be executed using it's "run" method, or by scheduling it to
		// execute.
		observableFutureList = Observable.fromFuture(future);

		// Schedule this future to run on the computation scheduler
		// computation schdueler is guarenteed to have 1 thread per core
		Schedulers.computation().scheduleDirect(future);   // Call the FutureTask's run method (argument can be future::run)

		// Subscribe to the list...when the list is ready through the
		// future, iterate and print each element.
		observableFutureList
				.subscribe((list) -> {
					list.forEach(System.out::println);
				});

		System.exit(0);
	}
}
