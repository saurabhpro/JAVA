package rx3.operators;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * Here we're Using zip, zipWith and zip (Iterable) operator to merge the emission in the Zipper function
 * <p>
 */

public class Ob4Zip {

    public static void main(String[] args) {
        exZip();
        exZipWith();
        exZipIterable();
    }

    /**
     * Uses Zip operator to get the stream on the Zipper function
     */
    private static void exZip() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.range(6, 5);
        Observable<Integer> elevenToFifteen = Observable.fromIterable(List.of(11, 12, 13, 14, 15));

        Observable.zip(oneToFive,
                        sixToTen,
                        elevenToFifteen,
                        (a, b, c) -> a + b + c) // since we have 3 emmitions we can run this zip function
                .subscribe(System.out::println);

    }

    /**
     * Uses ZipWith operator on the Observable to easily zip One Observable with another
     */
    private static void exZipWith() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.fromIterable(List.of(6, 7, 8, 9, 10));

        // if you only have two observables
        oneToFive.zipWith(sixToTen, Integer::sum)
                .subscribe(System.out::println);
    }

    /**
     * Uses zipIterable operator which takes List of Observables and provides the zipped emission in an array
     */
    private static void exZipIterable() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
        Observable<Integer> elevenToSixteen = Observable.just(11, 12, 13, 14, 15, 16);

        List<Observable<Integer>> observables = List.of(
                oneToFive,
                sixToTen,
                elevenToSixteen
        );

        // we can only zip if we have partner value - if not, it is skipped completely
        Observable.zip(observables, Arrays::toString)
                .subscribe(System.out::println);
    }
}