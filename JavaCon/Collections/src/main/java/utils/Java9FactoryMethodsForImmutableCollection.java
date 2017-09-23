/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

/**
 * all these new methods use
 * return Java8ImmutableCollections.List0.instance();
 * <p>
 * basically we replace
 * Xxx newC = Collections.unmodifiableXxx(existing_collection_name)
 */
public class Java9FactoryMethodsForImmutableCollection {
	public static void main(String[] args) {

		//Empty List Example
		List emptyImmutableList = List.of();
		System.out.println("emptyImmutableList: " + emptyImmutableList);

		//Non-Empty List Example
		List<String> nonEmptyImmutableList = List.of("one", "two", "three");
		nonEmptyImmutableList.forEach(System.out::println);


		//Sets
		Set<String> immutableSet = Set.of();
		System.out.println(immutableSet);
		immutableSet = Set.of("one", "two", "three"); //this is allowed - we overwrite the instance
		System.out.println(immutableSet);
		//immutableSet.add("this is not allowed");


		//Map has two set of methods: of() methods and ofEntries() methods to create
		// an Immutable Map object and an Immutable Map.Entry object respectively.

		//Empty Map Example
		Map emptyImmutableMap = Map.of();
		System.out.println("\nEmpty Immutable Map: " + emptyImmutableMap);

		//Non-Empty Map Example
		Map<Integer, String> nonemptyImmutableMap = Map.of(1, "one", 2, "two", 3, "three");
		System.out.println("\nNon-Empty Immutable Map\n");
		nonemptyImmutableMap.forEach((a, b) -> {
			System.out.println("Key: " + a + ", Value: " + b);
		});

		//Map.ofEntries() methods are used to create Immutable or Unmodifiable Maps using Entries.
		Map<Integer, String> emptyImmutableMapFromEntries = Map.ofEntries(entry(1, "one"), entry(2, "two"), entry(3, "three"));
		System.out.println("\nNon-Empty Immutable Map From Entries\n");
		nonemptyImmutableMap.forEach((a, b) -> {
			System.out.println("Key: " + a + ", Value: " + b);
		});

		//Map.Entry
		Map.Entry<Integer, String> immutableMapEntry = Map.entry(1, "one");
		System.out.println("\nImmutable Map.Entry: " + immutableMapEntry);
	}
}
