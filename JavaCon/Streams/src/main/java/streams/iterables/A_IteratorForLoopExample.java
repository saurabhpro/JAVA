/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.iterables;

import java.util.Arrays;
import java.util.List;

public class A_IteratorForLoopExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Apple", "Banana", "Orange");

		//Java 5 enhanced for loop:
		for (String s : list) {
			System.out.println(s);
		}
	}
}