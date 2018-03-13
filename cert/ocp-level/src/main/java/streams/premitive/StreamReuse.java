package streams.premitive;

import java.util.stream.IntStream;

class StreamReuse {
	public static void main(String[] args) {
		IntStream chars = "bookkeep".chars();

		System.out.println(chars.count());

		chars.distinct().sorted().forEach(ch -> System.out.printf("%c ", ch));
	}
}
