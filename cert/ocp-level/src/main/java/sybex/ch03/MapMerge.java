package sybex.ch03;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapMerge {
	public static void main(String[] args) {
		computeIfPresent();
//		computeIfAbsent();
	}

	static void merge() {
		// case 1:
		BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;

		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		favorites.put("Tom", "Tram");

		String jenny = favorites.merge("Jenny", "Skyride", mapper);
		String tom = favorites.merge("Tom", "Skyride", mapper);

		System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
		System.out.println(jenny); // Bus Tour
		System.out.println(tom); // Skyride

		// case 2
		// The mapping function is used only when there are two actual values to decide between.
		favorites.put("Sam", null);
		favorites.merge("Sam", "Skyride", mapper);
		System.out.println(favorites); // {Tom=Skyride, Sam=Skyride}

		// so mapper not called, doesn’t call the BiFunction at all, and it simply uses the new value:


		//case 3
		// what happens when the mapping function is called and returns null. The key is removed from the map when this happens
		mapper = (v1, v2) -> null;

		favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		favorites.put("Tom", "Bus Tour");
		favorites.merge("Jenny", "Skyride", mapper);
		favorites.merge("Sam", "Skyride", mapper);
		System.out.println(favorites); // {Tom=Bus Tour, Sam=Skyride}

		// Tom was left alone since there was no merge() call for that key.
		// Sam was added since that key was not in the original list.
		// Jenny was removed because the mapping function returned null.
	}

	private static void computeIfPresent() {
		Map<String, Integer> counts = new HashMap<>();
		counts.put("Jenny", 1);
		counts.put("Kou", null);
		BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;

		Integer jenny = counts.computeIfPresent("Jenny", mapper);
		Integer sam = counts.computeIfPresent("Sam", mapper);
		Integer kou = counts.computeIfPresent("Kou", mapper);

		System.out.println(counts); // {Kou=null, Jenny=2}
		System.out.println(jenny); // 2
		System.out.println(sam); // null
		System.out.println(kou); // null

		mapper = (k, v) -> null;
		jenny = counts.computeIfPresent("Jenny", mapper);
		System.out.println(jenny); // 2


	}

	private static void computeIfAbsent() {
		Map<String, Integer> counts = new HashMap<>();
		counts.put("Jenny", 15);
		counts.put(null, 66);
		Function<String, Integer> mapper = (k) -> 1;

		Integer jenny = counts.computeIfAbsent("Jenny", mapper);
		Integer sam = counts.computeIfAbsent("Sam", mapper);
		Integer kou = counts.computeIfAbsent(null, mapper);

		System.out.println(counts); // {null=66, Jenny=15, Sam=1}
		System.out.println(jenny); // 15
		System.out.println(sam); // 1
		System.out.println(kou); // 66

		mapper = (k) -> null;
		jenny = counts.computeIfAbsent("Jenny", mapper);
		System.out.println(jenny); // 15


	}
}
