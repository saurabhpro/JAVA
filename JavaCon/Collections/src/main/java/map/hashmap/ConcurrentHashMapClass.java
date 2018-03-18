/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Saurabh on 10/5/2015.
 */
public class ConcurrentHashMapClass {
	public static void main(String[] args) {
		//ConcurrentHashMap(int Capacity, float LoadFactor, int ConcurrencyLevel);
		Map<String, String> map = new ConcurrentHashMap<>();

		map.put("1", "1");
		map.put("2", "1");
		map.put("3", "1");
		map.put("4", "1");
		map.put("5", "1");
		map.put("6", "1");

		System.out.println("ConcurrentHashMap before iterator : " + map);

		Iterator<String> iterator = map.keySet().iterator();

		//noinspection WhileLoopReplaceableByForEach
		while (iterator.hasNext()) {
			String key = iterator.next();
			if (key.equals("3"))
				map.put(key + "new", "new3");

		}

		System.out.println("ConcurrentHashMap after Iterator : " + map);

		//hashmap
		map = new HashMap<>();

		map.put("1", "1");
		map.put("2", "1");
		map.put("3", "1");
		map.put("4", "1");
		map.put("5", "1");
		map.put("6", "1");

		System.out.println("HashMap before iterator : " + map);

        /*
         Iterator<String> iterator1 = map.keySet().iterator();
        while(iterator1.hasNext())
        replaced by simple foreach loop
         */
		for (String key : map.keySet()) {
			if (key.equals("3"))
				map.put(key + "new", "new3");   // java.util.ConcurrentModificationException

		}
		System.out.println("HashMap after iterator : " + map);

	}
}
