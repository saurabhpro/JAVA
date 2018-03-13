package concurrency;

import java.util.Arrays;
import java.util.List;

public class Concat {
	public static void main(String... questions) {
		Concat c = new Concat();
		List<String> list = Arrays.asList("Cat", "Hat");
		String x = c.concat1(list);
		String y = c.concat2(list);
		System.out.print(x + " " + y);
	}

	public String concat1(List<String> values) {
		return values.parallelStream()
				.reduce("a", (x, y) -> x + y,
						String::concat);
	}

	public String concat2(List<String> values) {
		return values.parallelStream().reduce((w, z) -> z + w).get();
	}
}