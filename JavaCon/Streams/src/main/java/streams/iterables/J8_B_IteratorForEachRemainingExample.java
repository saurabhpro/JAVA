/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.iterables;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class J8_B_IteratorForEachRemainingExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Apple", "Banana", "Orange");
		Iterator<String> i = list.iterator();

		i.next();   // moves over Apple

		i.forEachRemaining(System.out::println);
	}
}
/*
Banana
Orange
 */