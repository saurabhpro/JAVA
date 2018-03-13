package streams.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class ConsumerIn {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

		BiConsumer<String, Integer> b1 = map::put;
		BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);

		b1.accept("chicken", 7);
		b2.accept("lamb", 1);

		System.out.println(map);
	}
}
