/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.basics;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExplicitStreamOps {

	public static void main(String[] args) {
		// This anonymous inner class is equivalent to the lambda: item -> (item.startsWith(prefix))
		//noinspection Convert2Lambda
		Predicate<String> prefixSelector = new Predicate<>() {
			@Override
			public boolean test(String candidate) {
				String prefix = "2";
				return candidate.startsWith(prefix);
			}
		};

		List<String> myItems = List.of("1", "12", "2", "22");

		// datasource
		Stream<String> dataSource = myItems.stream();

		// intermediate operations
		/*
		 pipelining is simplified by the fact that the intermediate operation methods defined in Stream return
		 a reference to a Stream, allowing us to use the builder design pattern syntax, where we “chain” successive
		 calls to the methods in a single
		 */
		Stream<String> filtered = dataSource.filter(prefixSelector);
		@SuppressWarnings("Convert2MethodRef") Stream<String> mappedStream = dataSource.map(item -> item.toLowerCase());
		Collector<String, ?, List<String>> collector = Collectors.toList();

		// terminal operation
		List<String> myList = filtered.collect(collector);

		System.out.println(myList);


		// or
		String prefix = "2";
		@SuppressWarnings("Convert2MethodRef") List<String> filteredList = myItems.stream()
				.filter(item -> item.startsWith(prefix))
				.map(item -> item.toLowerCase())
				.collect(Collectors.toList());

	}
}

/*
 * More intermediate Methods
 * distinct()Returns a stream consisting of only the distinct items as determined by toString().
 * limit(int n) Returns a stream consisting of only the first “n” elements corresponding to the int parameter value.
 * skip(int n)Returns a stream consisting of all elements except the first “n” ones.
 * sort()Returns a stream that generates the elements in their natural sort order.
 */
