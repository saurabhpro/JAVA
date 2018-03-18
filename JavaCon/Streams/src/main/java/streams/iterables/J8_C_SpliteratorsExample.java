/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.iterables;

import java.util.Spliterator;
import java.util.Spliterators;

public class J8_C_SpliteratorsExample {

	public static void main(String[] args) {
		Spliterator<String> s = Spliterators.spliterator(
				new String[]{"one", "two"}, 0);

		s.forEachRemaining(System.out::println);
	}
}