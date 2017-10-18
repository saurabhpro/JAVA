/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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