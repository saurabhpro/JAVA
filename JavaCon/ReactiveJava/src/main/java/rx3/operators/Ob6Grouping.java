package rx3.operators;

import io.reactivex.rxjava3.core.Observable;

@SuppressWarnings("all")
public class Ob6Grouping {
    public static void main(String[] args) {
        exGrouping();
    }

    private static void exGrouping() {
        var source = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        var byLengths = source.groupBy(String::length);

        byLengths.flatMapSingle(Observable::toList)
                .subscribe(System.out::println);

        byLengths.flatMapSingle(
                        grp -> grp.reduce(
                                "",
                                (x, y) -> "".equals(x) ? y : x + ", " + y
                        ).map(s -> grp.getKey() + ": " + s)
                ).subscribe(System.out::println);
    }
}
