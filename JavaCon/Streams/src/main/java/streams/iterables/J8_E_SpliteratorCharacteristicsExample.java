/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.iterables;

import java.util.Arrays;
import java.util.List;

public class J8_E_SpliteratorCharacteristicsExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Apple", "Banana", "Orange");

		System.out.println(list.spliterator().characteristics());

		for (String s : list) {
			System.out.println(s);
		}
	}
}