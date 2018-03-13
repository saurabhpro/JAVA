package collection_n.merge;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MComputeIfAbsent {
	private static void computeIfAbsent() {
		Map<String, Integer> counts = new HashMap<>();
		counts.put("Jenny", 15);
		counts.put(null, 66);
		counts.put("Sam", null);

		System.out.println("With Non Null Mapper:");
		Map<String, Integer> originalClone = new HashMap<>(counts);
		withNonNullMapper(counts, originalClone);

		System.out.println("\nWith Null Mapper:");
		counts = new HashMap<>(originalClone);
		withNullMapper(counts, originalClone);
	}

	private static void withNonNullMapper(Map<String, Integer> counts, Map<String, Integer> originalClone) {
		// since value doesn't exist yet - we use Function instead of a bifunction
		Function<String, Integer> mapper = (k) -> 1;

		Integer jenny = counts.computeIfAbsent("Jenny", mapper);
		Integer sam = counts.computeIfAbsent("Sam", mapper);    //Sam is updated because null value is treated like not being there.
		Integer kou = counts.computeIfAbsent("kou", mapper);
		Integer nul = counts.computeIfAbsent(null, mapper);     // not updated since null is a valid key

		System.out.println("Original:");
		System.out.println(originalClone);  // {null=66, Jenny=15, Sam=null}
		System.out.println("after compute with non null returning mapper:");
		System.out.println(counts);         // {kou=1, null=66, Jenny=15, Sam=1}
	}

	private static void withNullMapper(Map<String, Integer> counts, Map<String, Integer> originalClone) {
		Function<String, Integer> mapper = (k) -> null;

		Integer jenny = counts.computeIfAbsent("Jenny", mapper);
		Integer sam = counts.computeIfAbsent("Sam", mapper);    //Sam remains @ null value.
		Integer kou = counts.computeIfAbsent("kou", mapper);    // not added since mapper is null
		Integer nul = counts.computeIfAbsent(null, mapper);     // not updated since mapper in null

		System.out.println("Original:");
		System.out.println(originalClone);  // {null=66, Jenny=15, Sam=null}
		System.out.println("after compute with non null returning mapper:");
		System.out.println(counts);         // {null=66, Jenny=15, Sam=null}


		Integer jen = counts.computeIfAbsent("Jen", mapper);
		System.out.println("\nJen was not added : " + jen); // null    // not added

	}


	public static void main(String[] args) {
		computeIfAbsent();
	}
}
