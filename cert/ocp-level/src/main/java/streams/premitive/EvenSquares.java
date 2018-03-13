package streams.premitive;

import java.util.stream.IntStream;

class EvenSquares {
	public static void main(String[] args) {

		// range(startValue, endValueExclusiveOfEnd)
		// rangeClosed(startValue, endValueInclusiveOfEnd)
		IntStream.rangeClosed(0, 10)
				.filter(i -> (i % 2) == 0)
				.map(i -> i * i)
				.forEach(System.out::println);
	}
}
/*
0
4
16
36
64
100
 */