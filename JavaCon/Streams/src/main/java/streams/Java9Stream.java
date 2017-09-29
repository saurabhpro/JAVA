/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java9Stream {

	public static void main(String[] args) {

		System.out.println("--- iterate ---");
		//IntStream.iterate(1, i -> i * 2).filter(i -> i < 20).forEach(System.out::println);
		//Java 9 Stream iterate() method adds a predicate as its second argument that checks condition to continue or not
		IntStream.iterate(1, i -> i < 20, i -> i * 2).forEach(System.out::println);

		System.out.println("--- takeWhile for ordered stream ---");
		Stream.of(1, 2, 3, 4, 5, 6).takeWhile(i -> i <= 3).forEach(System.out::println);

		System.out.println("--- takeWhile for unordered stream ---");
		Stream.of(1, 6, 5, 2, 3, 4).takeWhile(i -> i <= 3).forEach(System.out::println);

		System.out.println("--- dropWhile for ordered stream ---");
		Stream.of(1, 2, 3, 4, 5, 6).dropWhile(i -> i <= 3).forEach(System.out::println);

		System.out.println("--- dropWhile for unordered stream ---");
		Stream.of(1, 6, 5, 2, 3, 4).dropWhile(i -> i <= 3).forEach(System.out::println);

		System.out.println("--- ofNullable ---");
		long nullCount = Stream.ofNullable(null).count();

		System.out.println("nullable Count: " + nullCount);

		List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
		numbers.add(null);
		// numbers [1,2,3,null]

		Map<Integer, String> mapNumber = new HashMap<>(Map.of(1, "one", 2, "two", 3, "three"));
		mapNumber.put(null, null);
		// mapNumber [1 - one, 2 - two, 3 - three, null - null]

		System.out.println("--- check Null ---");
		List<String> stringNumbers = numbers.stream().flatMap(s -> {
			String temp = mapNumber.get(s);
			return (temp != null) ? Stream.of(temp) : Stream.empty();
		}).collect(Collectors.toList());
		System.out.println(stringNumbers);

		System.out.println("--- ofNullable ---");
		List<String> newStringNumbers = numbers.stream().flatMap(s -> Stream.ofNullable(mapNumber.get(s)))
				.collect(Collectors.toList());
		System.out.println(newStringNumbers);
	}
}