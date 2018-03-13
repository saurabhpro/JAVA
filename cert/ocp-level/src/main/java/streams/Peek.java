package streams;

import java.util.stream.Stream;

public class Peek {
	public static void main(String[] args) {
		Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
		infinite.limit(5)
				.peek((x) -> System.out.print(" "))
				.peek(System.out::print)
				.filter(x -> x % 2 == 1)
				.forEach(System.out::print);

		//  11 2 33 4 55
	}
}
