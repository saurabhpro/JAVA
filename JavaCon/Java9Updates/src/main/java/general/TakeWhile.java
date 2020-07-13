/*
 * Copyright (c) 2020 Saurabh Kumar
 */

package general;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class TakeWhile {
    public static void main(String[] args) {
        Stream.of("cat", "dog", "elephant", "fox", "rabbit", "duck")
                .takeWhile(n -> n.length() % 2 != 0)
                .forEach(System.out::println);

        //Let's compare this with the equivalent code in plain Java using a for loop and a break statement, to help us see how it works:

        List<String> list = asList("cat", "dog", "elephant", "fox", "rabbit", "duck");
        for (String item : list) {
            if (item.length() % 2 == 0) {
                break;
            }
            System.out.println(item);
        }
    }
}
