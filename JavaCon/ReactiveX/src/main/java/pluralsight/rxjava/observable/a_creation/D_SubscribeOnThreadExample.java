/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.a_creation;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
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

            // do chain call on the observable list to...
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
