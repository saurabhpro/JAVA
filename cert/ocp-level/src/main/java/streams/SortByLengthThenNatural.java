package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class SortByLengthThenNatural {
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