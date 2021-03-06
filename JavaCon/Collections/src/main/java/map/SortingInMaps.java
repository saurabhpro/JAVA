/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package map;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class SortingInMaps {

	@SuppressWarnings({"Convert2Lambda", "Java8ListSort"})
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueInJava7(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}


	// This will sort according to the value in ascending order;
	// for descending order, just uncomment the call to Collections.reverseOrder().
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueInJava8(Map<K, V> map) {
		return map.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(/*Collections.reverseOrder()*/))
				.collect(
						Collectors.toMap(
								Map.Entry::getKey,
								Map.Entry::getValue,
								(e1, e2) -> e1,
								LinkedHashMap::new
						)
				);
	}
}