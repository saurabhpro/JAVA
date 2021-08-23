package rx3.operators;

import io.reactivex.rxjava3.core.Observable;

public class Ob5Map {

    public static void main(String[] args) {
        exMap();
        exFlatMap();
        exMapWithObservable();
    }

    /**
     * This uses the map operators to change the emission in between before it reaches to it's subscriber
     */
    private static void exMap() {
        Observable<String> observable = Observable.just("foo", "bard", "james");
        observable
                .map(String::toUpperCase)
                .subscribe(System.out::println);
    }

    /**
     * This uses the flatMap to merge returned observables based on the emission
     */
    private static void exFlatMap() {
        Observable<String> observable = Observable.just("foo", "bar", "jam");
        observable.flatMap(item -> Observable.fromArray(item.split("")))
                .subscribe(System.out::println);
    }

    /**
     * This uses map operators to convert the stream in between to Observables
     * and for obvious reasons the subscribers get the Observable object instead
     */
    private static void exMapWithObservable() {
        Observable<String> observable = Observable.just("foo", "bar", "jam");
        observable.map(item -> Observable.fromArray(item.split("")))
                .subscribe(x -> System.out.println(x.blockingFirst()));
    }
}