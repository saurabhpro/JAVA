package streams.collect;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsToList {
	public static void main(String[] args) {
		String frenchCounting = "un:deux:trois:quatre";

		List<String> gmailList = Pattern.compile(":")
				.splitAsStream(frenchCounting)
				.collect(Collectors.toList());

		gmailList.forEach(System.out::println);
	}
}

class CollectorsToSet {
	public static void main(String[] args) {
		String[] roseQuote = "a rose is a rose is a rose".split(" ");
		Set<String> words = Arrays.stream(roseQuote).collect(Collectors.toSet()); // Set removes duplicates, this program prints only the words “a”, “rose” and “is” to the console.
		words.add("is");

		words.forEach(System.out::println);
	}
}

class CollectorsToMap {
	public static void main(String[] args) {
		Map<String, Integer> nameLength =
				Stream.of("Arnold", "Alois", "Schwarzenegger")
						.collect(Collectors.toMap(name -> name, name -> name.length()));

		nameLength.forEach((name, len) -> System.out.printf("%s - %d \n", name, len));

		// Collectors.toMap() method takes two arguments – the first one for keys and the second one for values.
		// Here, we have used the elements in the stream itself as the key and the length of the string as the value

		// We can simplify it by passing Function.identity() instead, as in:
		nameLength = Stream.of("Arnold", "Alois", "Schwarzenegger")
				.collect(Collectors.toMap(Function.identity(), name -> name.length()));
	}
}

class CollectorsToTreeSet {
	public static void main(String[] args) {
		String[] roseQuote = "a rose is a rose is a rose".split(" ");
		Set<String> words = Arrays.stream(roseQuote).collect(Collectors.toCollection(TreeSet::new));
		words.forEach(System.out::println);
	}
}

