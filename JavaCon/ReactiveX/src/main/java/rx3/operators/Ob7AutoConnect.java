package rx3.operators;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This saved us the trouble of having to save ConnectableObservable and call its
 * connect() method later. Instead, it will start firing when it gets 2 subscriptions, which we
 * have planned and specified as an argument in advance. Obviously, this does not work well
 * when you have an unknown number of observers and you want all of them to receive all
 * emissions
 */
public class Ob7AutoConnect {
    public static void main(String[] args) {
        Observable<Integer> rInts =
                Observable.range(1, 5)
                        .map(i -> randomInt())
                        .publish()
                        .autoConnect(2);

        //Observer 1 - prints each random integer
        rInts.subscribe(i -> System.out.println("Observer 1: " + i));

        //Observer 2 - sums the random integers, then prints
        rInts.reduce(0, (total, next) -> total + next)
                .subscribe(i -> System.out.println("Observer 2: " + i));

        //Observer 3 - receives nothing
        rInts.subscribe(i -> System.out.println("Observer 3:" + i));
    }

    private static int randomInt() {
        return ThreadLocalRandom.current().nextInt(0, 10000);
    }
}