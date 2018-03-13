package concurrency.stream;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

public class ParallelStream {
	public static void main(String[] args) {
		Arrays.asList(1, 2, 3, 4, 5, 6)
				.stream()
				.forEach(s -> System.out.print(s + " "));

		System.out.println();

		Arrays.asList(1, 2, 3, 4, 5, 6)
				.parallelStream()
				.forEach(s -> System.out.print(s + " "));

		System.out.println();

		// stream operations that occur before/after the forEachOrdered()
		// can still gain performance improvements for using a parallel stream.
		Arrays.asList(1, 2, 3, 4, 5, 6)
				.parallelStream()
				.forEachOrdered(s -> System.out.print(s + " "));


		List<Integer> data = Collections.synchronizedList(new ArrayList<>());
		Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream()
				.map(i -> {
					data.add(i);
					return i;
				}) // AVOID STATEFUL LAMBDA EXPRESSIONS!
				.forEachOrdered(i -> System.out.print(i + " "));

		System.out.println();
		for (Integer e : data) {
			System.out.print(e + " ");
		}

		System.out.println();
		System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).stream().findAny().get());
		System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().findAny().get());


		System.out.println(
				Arrays.asList('w', 'o', 'l', 'f')
						.stream()
						.reduce("", (c, s1) -> c + s1, (s2, s3) -> s2 + s3));

		/*
		Requirements for reduce() Arguments
		* The identity must be defined such that for all elements in the stream u, combiner.apply(identity, u) is equal to u.
		* The accumulator operator op must be associative and stateless such that (a op b) op c is equal to a op (b op c).
		* The combiner operator must also be associative and stateless and compatible with the identity, such that for all u and t combiner.apply(u,accumulator.apply(identity,t)) is equal to accumulator.apply(u,t).
		 */
		System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6)
				.parallelStream()
				.reduce(0, (a, b) -> (a - b))); // NOT AN ASSOCIATIVE ACCUMULATOR


		Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();

		SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);

		System.out.println(set); // [f, l, o, w]

	}
}
