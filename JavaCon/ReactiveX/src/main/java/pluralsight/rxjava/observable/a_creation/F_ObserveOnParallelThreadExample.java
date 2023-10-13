/*
 * Copyright 2017 Saurabh Kumar 29/10/17 1:14 PM
 */

package pluralsight.rxjava.observable.a_creation;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.TestSubscriber;

import java.util.List;
import java.util.stream.IntStream;

// https://www.baeldung.com/rxjava-2-flowable
public class F_ObserveOnParallelThreadExample {

    public static void main(String[] args) throws InterruptedException {
        thenAllValuesAreBufferedAndReceived();
    }

    public static void thenAllValuesAreBufferedAndReceived() throws InterruptedException {
        List<Integer> testList = IntStream.range(0, 100000)
                .boxed()
                .toList();

        Observable<Integer> observable = Observable.fromIterable(testList);
        TestSubscriber<Integer> testSubscriber = observable
                .toFlowable(BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.computation())
                .test();

        testSubscriber.await();

        List<Integer> receivedInts = testSubscriber.values();

        System.out.println(receivedInts);
        System.out.println(testList.equals(receivedInts));
    }
}
