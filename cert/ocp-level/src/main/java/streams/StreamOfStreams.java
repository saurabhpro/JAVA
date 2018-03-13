package streams;

import java.util.stream.Stream;

public class StreamOfStreams {
	public static void main(String[] args) {
		Integer result =
				Stream.of(getNums(9, 8), getNums(22, 33))
						.flatMap(x -> x)
						//.filter(x -> !x.isEmpty())
						.max((a, b) -> a - b)
						.get();
		System.out.println(result);
	}

	private static Stream<Integer> getNums(int num1, int num2) {
		return Stream.of(num1, num2);
	}
}