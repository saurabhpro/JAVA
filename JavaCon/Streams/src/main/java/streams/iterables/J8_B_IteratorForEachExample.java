/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.iterables;

import java.util.Arrays;
import java.util.List;

public class J8_B_IteratorForEachExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Apple", "Banana", "Orange");

		list.forEach(System.out::println);
	}
}