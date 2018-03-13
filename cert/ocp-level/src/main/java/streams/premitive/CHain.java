package streams.premitive;

import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toMap;

public class CHain {

	public static void main(String[] args) {
		BiFunction<Integer, Double, Integer> integerDoubleIntegerBiFunction = (a, b) -> a + (b > 100 ? 1 : 0);
		final Integer bi = integerDoubleIntegerBiFunction.apply(6, 99.0);

		BinaryOperator<Integer> integerBinaryOperator = (i1, i2) -> i1 + i2;
		final Integer apply = integerBinaryOperator.apply(bi, 88);

		IntUnaryOperator intUnaryOperator = (a) -> a + 1;
		final int i = intUnaryOperator.applyAsInt(apply);


		IntSupplier intSupplier = () -> 4 / 2;
		System.out.println(intSupplier.getAsInt());

		Consumer<Object> consumer = System.out::println;
	}
}

class DogSearch {
	public static void main(String[] treats) {
		int MAX_LENGTH = 2;
		DogSearch search = new DogSearch();
		List<String> names = new ArrayList<>();
		names.add("Lassie");
		names.add("Benji");
		names.add("Brian");
		// MAX_LENGTH += names.size();
		search.reduceList(names, d -> d.length() > MAX_LENGTH);
		System.out.print(names.size());

		Stream<String> stream = Stream.of("base", "ball");
		stream.map(s -> s.length())
				.forEach(System.out::print);

		IntStream s = IntStream.empty();
		// System.out.print(s.average().getAsDouble());    // NoSuchElementException

		List<Double> list = new ArrayList<>();
		list.add(5.4);
		list.add(1.2);
		Optional<Double> opt = list.stream().sorted().findFirst();
		System.out.println(opt.get() + " " + list.get(0));

		// Optional<String> opt3 = Optional.of(null);  // NullPointerException as @notnull
		// System.out.println(opt3.isPresent());

		Consumer<String> print = System.out::println;
		Stream.of("hi")
				.peek(print)
				.peek(print)
				.map(s1 -> s1)
				.peek(print)
				.forEach(print);

		Stream<Character> streamc = Stream.of('c', 'b', 'a'); // z1
		streamc.sorted()
				.findAny()
				.ifPresent(System.out::println);
	}

	void reduceList(List<String> names, Predicate<String> tester) {
		names.removeIf(tester);
	}
}

class MapOfMaps {
	// “ you can’t actually convert a Map into a Stream directly,”

	public static void main(String[] args) {
		Map<Integer, Integer> map1 = new HashMap<>();
		map1.put(9, 3);

		//System.out.println(result.keySet().iterator().next());


		Stream<String> s = Stream.of("speak", "bark", "meow", "growl");
		BinaryOperator<String> merge = (a, b) -> a;
		Map<Integer, String> map = s.collect(toMap(String::length, k -> k, merge));
		System.out.println(map);
		System.out.println(map.size() + " " + map.get(4));

		IntStream pages = IntStream.of(200, 300);
		IntSummaryStatistics stats = pages.summaryStatistics();
		long total = stats.getSum();
		long count = stats.getCount();
		System.out.println(total + "-" + count);

		Stream<Boolean> bools = Stream.iterate(true, b -> !b);
		Map<Boolean, List<Boolean>> map2 = bools.limit(1)
				.collect(partitioningBy(b -> b));
		System.out.println(map2);


		IntStream ints = IntStream.empty();
		IntStream moreInts = IntStream.of(66, 77, 88);
		Stream.of(ints, moreInts)
				.flatMapToInt(x -> x)
				.forEach(System.out::print);


		LongStream stream = LongStream.of(9);
		stream.mapToDouble(p -> p)
				.forEach(System.out::print);

		Stream<Character> streamc = Stream.of('c', 'b', 'a');
		System.out.println(streamc.sorted().findFirst());   // Optional[a]

	}
}