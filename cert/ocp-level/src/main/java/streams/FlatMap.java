package streams;

import java.util.*;
import java.util.stream.Stream;

/**
 * “The flatMap() method is used to turn a stream of streams into a one-dimensional stream.
 * This means it gets rid of the empty list and flattens the other two.”
 */
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


		Set<String> set = new HashSet<>();
		set.add("tire-");
		List<String> list = new LinkedList<>();
		Deque<String> queue = new ArrayDeque<>();
		queue.push("wheel-");

		Stream.of(set, list, queue)
				.flatMap(x -> x.stream())
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

class WithoutFlatMap {
	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		Deque<String> queue = new ArrayDeque<>();
		queue.push("all queued up");
		queue.push("last");

		withFlatMap(list);
		withoutFlatMap(list);
		withFlatMap(queue);
		withoutFlatMap(queue);
	}

	private static void withFlatMap(Collection<?> coll) {
		Stream.of(coll)
				.flatMap(x -> x.stream())
				.forEach(System.out::print);
		System.out.println();
	}

	private static void withoutFlatMap(Collection<?> coll) {
		Stream.of(coll)
				.filter(x -> !x.isEmpty())
				.map(x -> x)
				.forEach(System.out::print);
		System.out.println();
	}
}