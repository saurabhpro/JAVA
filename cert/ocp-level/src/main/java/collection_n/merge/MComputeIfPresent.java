package collection_n.merge;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MComputeIfPresent {
	private static void computeIfPresent() {
		Map<String, Integer> counts = new HashMap<>();
		counts.put("Jenny", 15);
		counts.put("Sam", null);
		counts.put(null, 66);

		System.out.println("With Non Null Mapper:");
		Map<String, Integer> originalClone = new HashMap<>(counts);
		withNonNullMapper(counts, originalClone);


		System.out.println("\nWith Null Mapper:");
		counts = new HashMap<>(originalClone);
		withNullMapper(counts, originalClone);
	}

	private static void withNullMapper(Map<String, Integer> counts, Map<String, Integer> originalClone) {
		BiFunction<String, Integer, Integer> mapper = (k, v) -> null;

		Integer jenny = counts.computeIfPresent("Jenny", mapper);
		Integer sam = counts.computeIfPresent("Sam", mapper);   // if key present -> value = null -> mapper not called
		Integer nul = counts.computeIfPresent(null, mapper);


		System.out.println("Original:");
		System.out.println(originalClone);  // {null=66, Jenny=15, Sam=null}
		System.out.println("after compute with non null returning mapper:");
		System.out.println(counts);         // {Sam=null}
	}

	private static void withNonNullMapper(Map<String, Integer> counts, Map<String, Integer> originalClone) {
		BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;

		Integer jenny = counts.computeIfPresent("Jenny", mapper);
		Integer sam = counts.computeIfPresent("Sam", mapper);   // not updated since mapper not called if value is null
		Integer nul = counts.computeIfPresent(null, mapper);

		// Just like with merge(), the return value is the result of what changed in the map or null if that doesn’t apply.
		System.out.println("Original:");
		System.out.println(originalClone);  // {null=66, Jenny=15, Sam=null}
		System.out.println("after compute with non null returning mapper:");
		System.out.println(counts);         // {null=67, Jenny=16, Sam=null}
	}

	public static void main(String[] args) {
		computeIfPresent();
	}
}
