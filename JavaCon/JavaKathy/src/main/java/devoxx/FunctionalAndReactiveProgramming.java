package devoxx;

import io.reactivex.rxjava3.core.Flowable;

import java.util.List;

public class FunctionalAndReactiveProgramming {

    public static boolean isEven(int number) {
        System.out.println("isEven called for " + number);
        return number % 2 == 0;
    }

    public static int doubleIt(int number) {
        System.out.println("doubleIt called for " + number);
        return number * 2;
    }

    public static void main(String[] args) {
        final var numbers = List.of(1, 2, 3, 4, 5, 6);

        // functional style
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * 2)
            .limit(1)       // it called filters on the whole list and then mapped all values only to pick 1 value
            .forEach(System.out::println);

        // functional style + lazy eval = functional programming
        numbers.stream()
            .filter(FunctionalAndReactiveProgramming::isEven)
            .map(FunctionalAndReactiveProgramming::doubleIt)
            .limit(1)
            .forEach(System.out::println);

        System.out.println("--------");
        Flowable.fromIterable(numbers)
            .filter(FunctionalAndReactiveProgramming::isEven)
            .map(FunctionalAndReactiveProgramming::doubleIt)
            .take(1)
            .subscribe(System.out::println);
    }
}

//Functional style == declarative + higher order functions

//Functional programming == functional composition + lazy evaluation

//Reactive programming == Functional programming++

class TestFunc {

    public static int doubleIt(int number) {
        System.out.println("doubleIt called for " + number);
        return number * 2;
    }

    public static void main(String[] args) {
        final var numbers = List.of(1, 2, 3, 4, 5, 6);

        // functional style
        numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(TestFunc::doubleIt)
            .limit(1)       // it called filters on the whole list and then mapped all values only to pick 1 value
            .forEach(System.out::println);
    }
}