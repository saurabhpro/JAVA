package streams;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class op {
	public static void main(String[] args) {

		Optional<String> nullStr = Optional.of(null);//NullPointerException
		// if you want to create optionals with null value - i.e. Optional.empty()

		Optional<String> nullableStr = Optional.ofNullable(null);

		String[] string = "you never know what you have until you clean your room".split(" ");
		System.out.println(
				Arrays.stream(string)
						.min(String::compareTo)
						.get()
		);

		//You can also directly call methods such as sum() and average() provided in IntStream, as in:
		IntStream.of(10, 20, 30, 40).sum();
		//These methods are more concise than their equivalent using the reduce() method:
		IntStream.of(10, 20, 30, 40).reduce(0, ((sum, val) -> sum + val)); // reduce() is a generalized method
	}

	public static void selectHighestTemperature(Stream<Double> temperatures) {
		Optional<Double> max = temperatures.max(Double::compareTo);
		if (max.isPresent()) {
			System.out.println(max.get());
		}

		// same as
		max.ifPresent(System.out::println);
	}
}


class WordStatistics {
	public static void main(String[] args) {
		String limerick = "There was a young lady named Bright " +
				"who traveled much faster than light " +
				"She set out one day " +
				"in a relative way " +
				"and came back the previous night ";

		IntSummaryStatistics wordStatistics =
				Pattern.compile(" ")
						.splitAsStream(limerick) // splitAsStream() method in the Pattern class
						.mapToInt(word -> word.length())
						.summaryStatistics();

		System.out.printf(" Number of words = %d \n Sum of the length of the words = %d \n"
						+ " Minimum word size = %d \n Maximum word size %d \n" +
						" Average word size = %f \n", wordStatistics.getCount(),
				wordStatistics.getSum(), wordStatistics.getMin(),
				wordStatistics.getMax(), wordStatistics.getAverage()
		);
	}
}

class SortByLengthThenNatural {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("follow your heart but take your brain with you".split(" "));

		// basic
		words.stream()
				.distinct()
				.sorted() // sorts the elements in their “natural order”; requires that the elements in the stream implement the Comparable interface.
				.forEach(System.out::println);

		// basics
		Comparator<String> lengthCompare = (str1, str2) -> str1.length() - str2.length();
		words.stream()
				.distinct()
				.sorted(lengthCompare)
				.forEach(System.out::println);

		// chained sorting
		words.stream()
				.distinct()
				.sorted(
						lengthCompare
								.thenComparing(String::compareTo)
								.reversed() // method in comparator interface
				)
				.forEach(System.out::println);
	}
}