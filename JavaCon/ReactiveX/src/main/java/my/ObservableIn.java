/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package my;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Random;

public class ObservableIn {
    public static void main(String[] args) {

        Observable<Integer> vals = Observable.range(1, 10);

        final Disposable subscribe = vals.subscribeOn(Schedulers.computation())
                .map(ObservableIn::intenseCalculation)
                .subscribe(
                        val -> System.out.println("Subscriber received " + val + " on " + Thread.currentThread().getName()));

        subscribe.dispose();
    }

    public static int intenseCalculation(int i) {
        try {
            System.out.println("Calculating " + i + " on " + Thread.currentThread().getName());

            Thread.sleep(new Random().nextInt(5000));

            return i;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void simpleOb(Observable<Integer> vals) {
        vals.subscribe(System.out::println);
    }

    static void taskOb(Observable<Integer> vals) {
        vals.map(ObservableIn::intenseCalculation)
                .subscribe(val -> System.out.println(val));

    }
}
