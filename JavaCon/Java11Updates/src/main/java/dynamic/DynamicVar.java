/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package dynamic;

import java.util.ArrayList;

public class DynamicVar {

	public static void main(String[] args) {
		var test = new ArrayList<>();
		test.add("77");
		test.add(88);

		var stream = test.stream();

		stream.forEach(System.out::println);
	}
}