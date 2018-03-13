package collection_n.merge;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MapMerge {
	public static void main(String[] args) {
		merge();
	}

	private static void merge() {

		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		favorites.put("Tom", "Bus");
		favorites.put(null, "Skyride");
		favorites.put("Sam", null);


		System.out.println("With Non Null Mapper:");
		Map<String, String> clone = new HashMap<>(favorites);
		withNonNullMapper(favorites, clone);


		//case 3
		System.out.println("\nWith Null Mapper:");
		favorites = new HashMap<>(clone);
		withNullMapper(favorites, clone);

	}

	private static void withNonNullMapper(Map<String, String> favorites, Map<String, String> clone) {
		// case 1:
		BiFunction<String, String, String> mapper = (o1, v2) -> o1.length() > v2.length() ? o1 : v2;

		String jenny = favorites.merge("Jenny", "Skyride", mapper);
		String tom = favorites.merge("Tom", "Skyride", mapper);
		String nul = favorites.merge(null, "Skyrider", mapper);  // updated

		System.out.println("Original:");
		System.out.println(clone);
		System.out.println("after compute with non null returning mapper:");


		// case 2
		// The mapping function is used only when there are two actual values to decide between.
		favorites.merge("Sam", "Skyrider", mapper);  // mapper not called since value is null
		System.out.println(favorites); // {null=Skyride, Tom=Skyride, Jenny=Bus Tour, Sam=Skyrider}

		// so mapper not called, doesn’t call the BiFunction at all, and it simply uses the new value:
	}

	private static void withNullMapper(Map<String, String> favorites, Map<String, String> clone) {
		BiFunction<String, String, String> mapper = (o1, v2) -> null;
		// what happens when the mapping function is called and returns null. The key is removed from the map when this happens

		favorites.merge("Jenny", "Skyride", mapper);
		favorites.merge("Sam", "Skyride", mapper);
		favorites.merge(null, "Skyride", mapper);


		System.out.println("Original:");
		System.out.println(clone);
		System.out.println("after compute with non null returning mapper:");
		System.out.println(favorites); // {Tom=Bus, Sam=Skyride}

		// Tom was left alone since there was no merge() call for that key.
		// Sam was added since that key was not in the original list.
		// Jenny was removed because the mapping function returned null.
	}
}
