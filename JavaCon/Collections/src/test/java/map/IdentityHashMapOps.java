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

import org.junit.jupiter.api.Test;
import set.Student;

import java.util.IdentityHashMap;

public class IdentityHashMapOps {
	@Test
	void test() {
		IdentityHashMap<Integer, Student> map = new IdentityHashMap<>();
		Student s1 = new Student(12345, "John", "Smith");
		map.put(s1.getId(), s1);
		map.put(s1.getId(), s1);
		for (Student s : map.values()) {
			System.out.println(s.getId() + " " + s.getFname());
		}

		/*output
		12345 John
		12345 John
		 */
	}
}

/*
The student identifier is actually a primitive value, and as you may recall from earlier in
the chapter, Java’s autoboxing feature simply creates wrappers around primitive values when they’re specified.
Therefore, the previous two lines of code that add the Student to the map twice are functionally identical to the following:
map.put(new Integer(s1.getStudentID()), s1);
map.put(new Integer(s1.getStudentID()), s1);

As this illustrates, a separate object is being created for each key value, which explains
why the IdentityHashMap was able to hold what initially appeared to be duplicates even by its own very restrictive definition.
 */