package concurrency.stream;

import java.util.Arrays;

public class Bounce {
	public static void main(String... legend) {
		Arrays.asList(1, 2, 3, 4).stream()
				.forEach(System.out::println);
		Arrays.asList(1, 2, 3, 4).parallelStream()
				.forEachOrdered(System.out::println);
	}
}