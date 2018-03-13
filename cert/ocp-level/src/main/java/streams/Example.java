package streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Example {

	public static void main(String[] args) {
		referencedPipeline();

		allMatchHangs();


		noneMatch();


		onlyAllMatchGivesFalse();


		/*
		IntStream is = IntStream.empty();
		final int sum = is.sum();
		final OptionalInt max = is.max();
		final OptionalDouble average = is.average();
		final OptionalInt any = is.findAny();
		*/

		LongStream ls = LongStream.of(1, 2, 3);
		OptionalLong opt = ls.map(n -> n * 10)
				.filter(n -> n < 5)
				.findFirst();

		if (opt.isPresent()) System.out.println(opt.getAsLong());
		opt.ifPresent(System.out::println);

		final String collect = Stream.iterate(1, x -> x++).limit(5).map(x -> "" + x).collect(Collectors.joining());
		// Stream.iterate(1, x -> x++).limit(5).map(x -> "" + x).collect(Collectors.partitioningBy(a-> a.startsWith("1"), Map<Boolean, List<String>> ));

		List<Integer> l1 = Arrays.asList(1, 2, 3);
		List<Integer> l2 = Arrays.asList(4, 5, 6);
		List<Integer> l3 = Arrays.asList();
		Stream.of(l1, l2, l3)
				.flatMap(x -> x.stream())
				.map(x -> x + 1)
				.forEach(System.out::print);
		System.out.println();


		Stream<Integer> s = Stream.of(1);
		IntStream is = s.mapToInt(x -> x);
// 		DoubleStream ds = s.mapToDouble(x -> x);
		// Stream<Integer> s2 = ds.mapToInt(x -> x);    // double stream -> double cannot be converted to int
		// s2.forEach(System.out::print);


		collector();

		DoubleStream ds2 = DoubleStream.of(1.2, 2.4);
		ds2.peek(System.out::println).filter(x -> x > 2).count();


		List<Integer> l = IntStream.range(1, 6)
				.mapToObj(i -> i)
				.collect(Collectors.toList());
		l.forEach(System.out::println);

		IntStream.range(1, 6)
				.forEach(System.out::println);


	}

	private static void referencedPipeline() {
		Stream<String> stream = Stream.iterate("", (s) -> s + "1");

		System.out.println(stream
				.limit(2)
				.map(x -> x + "2")
		);      // java.util.stream.ReferencePipeline$3@10f87f48
		// no terminal operation is called, so the stream never executes

		Stream.iterate("", (s) -> s + "1")
				.limit(4)
				.map(x -> x + "2 ")
				.forEach(System.out::print);

		System.out.println();
	}

	private static void collector() {
		Stream<String> s = Stream.empty();
		Stream<String> s2 = Stream.empty();
		Map<Boolean, List<String>> p = s.collect(Collectors.partitioningBy(b -> b.startsWith("c")));
		Map<Boolean, List<String>> g = s2.collect(Collectors.groupingBy(b -> b.startsWith("c")));
		System.out.println(p + " " + g);
	}

	private static void onlyAllMatchGivesFalse() {
		Stream<String> s = Stream.generate(() -> "meow");
		boolean match = s.allMatch(String::isEmpty);
		System.out.println(match);
	}

	private static void noneMatch() {
		Predicate<? super String> predicate = s -> s.length() > 3;
		Stream<String> stream = Stream.iterate("-", (s) -> s + s);
		boolean b1 = stream.noneMatch(predicate);   // b1 is set to false because Java finds an element that doesn’t match when it gets to the element of length 4.
		//boolean b2 = stream.anyMatch(predicate);    // IllegalStateException: stream has already been operated upon or closed
		System.out.println(b1 + " ");
	}

	private static void allMatchHangs() {
		Predicate<? super String> predicate = s -> s.startsWith("g");
		Stream<String> stream1 = Stream.generate(() -> "growl! ");
		Stream<String> stream2 = Stream.generate(() -> "growl! ");
		boolean b1 = stream1.anyMatch(predicate);
		System.out.println("anyMatch: " + b1);
		//boolean b2 = stream2.allMatch(predicate); // infinitely hangs the app
		// System.out.println("allMatch: "+ b2);
	}


	private static List<String> sort(List<String> list) {
		List<String> copy = new ArrayList<>(list);
		Collections.sort(copy, (a, b) -> b.compareTo(a));
		//return copy;

		//same as above
		return list.stream()
				.sorted((a, b) -> b.compareTo(a))
				.collect(Collectors.toList());
	}

}
