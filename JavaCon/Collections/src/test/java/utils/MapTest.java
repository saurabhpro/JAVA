/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package utils;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;

public class MapTest {

	@Test
	public void testAssertMap() {

		Map<String, String> map = new HashMap<>();
		map.put("j", "java");
		map.put("c", "c++");
		map.put("p", "python");
		map.put("n", "node");

		Map<String, String> expected = new HashMap<>();
		expected.put("n", "node");
		expected.put("c", "c++");
		expected.put("j", "java");
		expected.put("p", "python");

		//All passed / true

		//1. Test equal, ignore order
		MatcherAssert.assertThat(map, is(expected));

		//2. Test size
		MatcherAssert.assertThat(map.size(), is(4));

		//3. Test map entry, best!
		MatcherAssert.assertThat(map, IsMapContaining.hasEntry("n", "node"));

		MatcherAssert.assertThat(map, not(IsMapContaining.hasEntry("r", "ruby")));

		//4. Test map key
		MatcherAssert.assertThat(map, IsMapContaining.hasKey("j"));

		//5. Test map value
		MatcherAssert.assertThat(map, IsMapContaining.hasValue("node"));

	}
}