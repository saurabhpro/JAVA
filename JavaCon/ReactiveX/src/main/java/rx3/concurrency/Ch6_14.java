package rx3.concurrency;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import static pluralsight.rxjava.observable.util.ThreadUtils.sleep;

/**
 * The observeOn() operator,
 * however, will intercept emissions at that point in the Observable chain and switch them to
 * a different Scheduler going forward.
 */
public class Ch6_14 {
    // program to find numbers from string and join them to yield total sum
    public static void main(String[] args) {
        Observable.just("WHISKEY/27653/TANGO",
                        "6555/BRAVO",
                        "232352/5675675/FOXTROT")
                .subscribeOn(Schedulers.io())    //Starts on I/O scheduler
                .flatMap(s -> Observable.fromArray(s.split("/")))
                .observeOn(Schedulers.computation()) //Switches to  computation scheduler
                .filter(s -> s.matches("[0-9]+"))
                .map(Integer::valueOf)
                .reduce(Integer::sum)
                .subscribe(i -> System.out.println("Received " + i + " on thread " + Thread.currentThread().getName()));

        // 27653+6555+232352+5675675 = 5942235
        sleep(1000);
    }
}