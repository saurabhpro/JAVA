/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package utils;

import map.SortingInMaps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

class SortingInMapsTest {
	Map<String, Integer> testMap = new HashMap<>(1000);

	@BeforeEach
	void setUp() {
		Random random = new Random(System.currentTimeMillis());
		IntStream.range(0, 1000).forEach(i -> testMap.put("SomeString" + random.nextInt(), random.nextInt()));
	}

	@Test
	void sortByValue() {
		testMap = SortingInMaps.sortByValueInJava7(testMap);
		Assertions.assertEquals(1000, testMap.size());

		Integer previous = null;
		for(Map.Entry<String, Integer> entry : testMap.entrySet()) {
			Assertions.assertNotNull(entry.getValue());
			if (previous != null) {
				Assertions.assertTrue(entry.getValue() >= previous);
			}
			previous = entry.getValue();
		}
	}

	@Test
	void sortByValueJ8() {
		testMap = SortingInMaps.sortByValueInJava8(testMap);
		Assertions.assertEquals(1000, testMap.size());

		testMap.forEach((key, value) -> Assertions.assertNotNull(value));
	}
}