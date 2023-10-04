/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.a_creation;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
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
        // computation scheduler is guaranteed to have 1 thread per core
        Schedulers
                .computation()
                .scheduleDirect(future);   // Call the FutureTask's run method (argument can be future::run)

        // Subscribe to the list...when the list is ready through the
        // future, iterate and print each element.
        observableFutureList
                .subscribe(list -> {
                    list.forEach(System.out::println);
                });

        System.exit(0);
    }
}
