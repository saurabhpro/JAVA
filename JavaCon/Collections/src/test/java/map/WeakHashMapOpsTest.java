/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import set.Student;

import java.util.HashMap;
import java.util.WeakHashMap;

class WeakHashMapOpsTest {

	@Test
	@DisplayName("weak hash map cleared if its reference is garbage collected")
	void Test() {
		WeakHashMap<Integer, Student> map = new WeakHashMap<>();
		Student s1 = new Student(12345, "John", "Smith");
		Student s2 = new Student(24680, "Jane", "Smith");
		Student s3 = new Student(13579, "Adam", "Smith");
		Student s4 = new Student(67890, "Tom", "Jones");

		map.put(s1.getId(), s1);
		map.put(s2.getId(), s2);
		map.put(s3.getId(), s3);
		map.put(s4.getId(), s4);

		s1 = null;
		System.out.println("The map initially contained " + map.size() + " entries");
		map.forEach((key, val) -> System.out.println(val.getFname()));
		System.gc();
		System.out.println("\nThe map now contains " + map.size() + " entries" + " with s2 = " + s2);
		map.forEach((key, val) -> System.out.println(val.getFname()));

		/*
		What happened in this case is that the call to the System.gc() method prompted the garbage collector to run.
		Since it found only weak references to the keys associated with the four Student values,
		it removed them from the system and by extension from the WeakHashMap.

		Understanding how WeakHashMap works also illustrates how it can be valuable. It allows you to provide a
		caching mechanism for data without forcing you to explicitly remove items from the cache to ensure that
		your application doesn’t run out of memory. Instead, items will be removed automatically when they’re garbage collected.
		 */
	}

	@Test
	@DisplayName("hash map not cleared if its one reference is garbage collected")
	void Test2() {

		HashMap<Integer, Student> map = new HashMap<>();
		Student s1 = new Student(12345, "John", "Smith");
		Student s2 = new Student(24680, "Jane", "Smith");
		Student s3 = new Student(13579, "Adam", "Smith");
		Student s4 = new Student(67890, "Tom", "Jones");

		map.put(s1.getId(), s1);
		map.put(s2.getId(), s2);
		map.put(s3.getId(), s3);
		map.put(s4.getId(), s4);

		s1 = null;
		System.out.println("The map initially contained " + map.size() + " entries");
		map.forEach((key, val) -> System.out.println(val.getFname()));
		System.gc();
		System.out.println("\nThe map now contains " + map.size() + " entries" + " with s2 = " + s2);
		map.forEach((key, val) -> System.out.println(val.getFname()));
	}
}