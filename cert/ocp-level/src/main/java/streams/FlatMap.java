package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMap {
	public static void main(String[] args) {
		String[] string = "you never know what you have until you clean your room".split(" ");
		Stream<String> distinctWords = Arrays.stream(string).distinct();


		Stream<String[]> distinct = Arrays.stream(string)
				.map(word -> word.split("")) // returns []
				.distinct();

		distinct.forEach(System.out::print); // tries to print array - so gibberish

		// hence flatMap
		Arrays.stream(string)
				.flatMap(word -> Arrays.stream(word.split("")))
				.distinct()
				.forEach(System.out::print);


	}
}


class UsingFlatMap {
	public static void main(String[] args) {
		List<List<Integer>> intsOfInts = Arrays.asList(
				Arrays.asList(1, 3, 5),
				Arrays.asList(2, 4)
		);

		intsOfInts.stream()
				.flatMap(ints -> ints.stream())
				.sorted()
				.map(i -> i * i)
				.forEach(System.out::println);
	}
}