/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.iterables;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class J8_C_SpliteratorTryAdvanceExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Apple", "Banana", "Orange");

		Spliterator<String> s = list.spliterator();
		s.tryAdvance(System.out::println);
		System.out.println(" --- bulk traversal");
		s.forEachRemaining(System.out::println);

		System.out.println(" --- attempting tryAdvance again");
		boolean b = s.tryAdvance(System.out::println);
		System.out.println("Element exists: " + b);

	}
}

/*
Apple
 --- bulk traversal
Banana
Orange
 --- attempting tryAdvance again
Element exists: false
 */