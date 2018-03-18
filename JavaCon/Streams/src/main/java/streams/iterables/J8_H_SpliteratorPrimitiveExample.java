/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.iterables;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.IntConsumer;

public class J8_H_SpliteratorPrimitiveExample {
	public static void main(String[] args) {
		int[] ints = {3, 4, 6, 7};
		Spliterator.OfInt s = Arrays.spliterator(ints);

		s.forEachRemaining((IntConsumer) System.out::println);
	}
}