package streams.collect;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Stream.collect() using Supplier, Accumulator and Combiner
public class StreamCollect {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Mukesh", "Vishal", "Amar");
		String result = list.parallelStream()
				.collect(StringBuilder::new,
						(response, element) -> response.append(" ").append(element),
						(response1, response2) -> response1.append(",").append(response2.toString())
				)
				.toString();
		System.out.println("Result: " + result);
	}
}

class SumOfListDemo {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(23, 43, 12, 25);

		IntSummaryStatistics stats = list.stream()
				.collect(Collectors.summarizingInt(i -> i + i));

		System.out.println("Sum:" + stats.getSum());
	}
}

class JoiningExample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Ram", "Shyam", "Shiv", "Mahesh");
		String result = list.stream().collect(Collectors.joining(", "));
		System.out.println("Joining Result: " + result);
	}
}

class AveragingIntExample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		Double result = list.stream().collect(Collectors.averagingInt(v -> v * 2));
		System.out.println("Average: " + result);
	}
}

class CountingExample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		long result = list.stream().collect(Collectors.counting());
		System.out.println("Count: " + result);
	}
}

class GroupingExample {
	public static void main(String[] args) {
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears");

		Map<Integer, List<String>> map =
				ohMy.collect(
						Collectors.groupingBy(String::length));

		System.out.println(map); // {5=[lions, bears], 6=[tigers]}


		Map<Integer, Set<String>> map2 =
				ohMy.collect(
						Collectors.groupingBy(String::length, Collectors.toSet()));

		System.out.println(map2); // {5=[lions, bears], 6=[tigers]}
	}
}

class GroupStringsByLength {
	public static void main(String[] args) {
		String[] string = "you never know what you have until you clean your room".split(" ");
		Stream<String> distinctWords = Arrays.stream(string).distinct();

		// The groupingBy() method in Collectors class takes a Function as an argument.
		// It uses the result of the function to return a Map.
		Map<Integer, List<String>> wordGroups = distinctWords.collect(Collectors.groupingBy(String::length));

		wordGroups.forEach((count, words) -> {
			System.out.printf("word(s) of length %d %n", count);

			words.forEach(System.out::println);
		});

		distinctWords = Arrays.stream(string).distinct();
		// you want to separate longer words from smaller words? For that you can use partitioningBy() with Predicate argument
		Map<Boolean, List<String>> wordBlocks =
				distinctWords.collect(Collectors.partitioningBy(str -> str.length() > 4));

		System.out.println("Short words (len <= 4): " + wordBlocks.get(false));
		System.out.println("Long words (len > 4): " + wordBlocks.get(true));
	}
}
