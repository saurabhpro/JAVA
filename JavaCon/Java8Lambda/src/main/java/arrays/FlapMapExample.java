package arrays;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlapMapExample {

    private static void map() {
        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());


        //assertEquals(asList("A", "B"), myList);

        List<List<String>> list = List.of(
                List.of("a", "x"),
                List.of("b", "y"));
        System.out.println(list);

        //This snippet prints a list of lists [[a, x], [b, y]].
        //Now, let's use a flatMap():


    }

    private static void flatMap() {
        List<List<String>> list = List.of(
                List.of("a", "x"),
                List.of("b", "y")
        );

        System.out.println(list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
        //[a, x, b, y]

        List<List<List<String>>> list2 = List.of(
                List.of(List.of("a", "x"), List.of("p", "q")),
                List.of(List.of("b", "y"), List.of("r", "s"))
        );

        System.out.println(list2
                .stream()
                .flatMap(Collection::stream)
                .flatMap(strings -> strings.stream())
                .collect(Collectors.toList()));

        //[a, x, p, q, b, y, r, s]
    }

    public static void main(String[] args) {
        map();
        flatMap();
    }
}
