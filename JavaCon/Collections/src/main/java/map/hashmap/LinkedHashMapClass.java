/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package map.hashmap;

import java.util.LinkedHashMap;

/**
 * Created by Saurabh on 10/5/2015.
 * A LinkedHashMap contains values based on the key. It implements the Map interface and extends HashMap class.
 * It contains only unique key elements, and can have duplicate values.
 * It may have one null key and multiple null values.
 * It is same as HashMap instead MAINTAINS INSERTION ORDER!!!
 */
public class LinkedHashMapClass {
	public static void main(String[] args) {
		final var hm = new LinkedHashMap<Integer, String>();
		hm.put(100, "Amit");
		hm.put(101, "Vijay");
		hm.put(102, "Rahul");

		for (final var m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		// java 21 updates
		System.out.println("firstEntry: " + hm.firstEntry());
		System.out.println("lastEntry: " + hm.lastEntry());
		System.out.println("pollFirstEntry: " + hm.pollFirstEntry());
		System.out.println("pollFirstEntry: " + hm.pollFirstEntry());

		System.out.println("reversed: " + hm.reversed());
		System.out.println("sequencedValues: " + hm.sequencedValues());
		System.out.println("sequencedKeySet: " + hm.sequencedKeySet());
		System.out.println("sequencedEntrySet: " + hm.sequencedEntrySet());
	}
}
/*
 * OUTPUT [insertion parts maintained]
 * 100 Amit
 * 101 Vijay
 * 102 Rahul
 */
