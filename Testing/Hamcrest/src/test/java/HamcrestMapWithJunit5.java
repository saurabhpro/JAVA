/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;

class HamcrestMapWithJunit5 {

	@Test
	void testAssertMap() {

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