/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.iterables;

import java.util.*;

/**
 * ORDERED indicates that the elements have a defined order, which is expected from a List, when traversing and partitioning them.
 * SORTED means that the elements follow a predefined sort order while
 * SUBSIZED indicates that this and any further resulting Spliterator are SIZED.
 * SIZED means the Spliterator has been created from a source with a known size.
 */
public class J8_E_SpliteratorCharacteristics {
	public static void main(String[] args) {
		Set<String> list = Set.of("7");

		Spliterator<String> s = list.spliterator();
		printCharacteristics("Set", s);

		List<String> l = List.of();
		s = l.spliterator();
		printCharacteristics("List", s);        // doesn't print immutable !!!

		//Maps have spliterator they have ???
		HashMap tu = new HashMap();

		TreeSet<String> t = new TreeSet<>();
		t.add("s");
		t.add("s");
		t.add("t");
		s = t.spliterator();
		printCharacteristics("TreeSet", s);
	}

	private static void printCharacteristics(String type, Spliterator<String> s) {
		System.out.println("\nCharacteristics for " + type + "\n");

		if (s.hasCharacteristics(Spliterator.ORDERED)) {
			System.out.println("ORDERED");
		}
		if (s.hasCharacteristics(Spliterator.DISTINCT)) {
			System.out.println("DISTINCT");
		}
		if (s.hasCharacteristics(Spliterator.SORTED)) {
			System.out.println("SORTED");
		}
		if (s.hasCharacteristics(Spliterator.SIZED)) {
			System.out.println("SIZED");
		}

		if (s.hasCharacteristics(Spliterator.CONCURRENT)) {
			System.out.println("CONCURRENT");
		}
		if (s.hasCharacteristics(Spliterator.IMMUTABLE)) {
			System.out.println("IMMUTABLE");
		}
		if (s.hasCharacteristics(Spliterator.NONNULL)) {
			System.out.println("NONNULL");
		}
		if (s.hasCharacteristics(Spliterator.SUBSIZED)) {
			System.out.println("SUBSIZED");
		}
	}
}