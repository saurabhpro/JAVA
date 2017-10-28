/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package set;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;


class SetOpsTest {

	@Test
	void test() {
		Collection<Student> collection = new HashSet<>();
		Student s1 = new Student(12345, "John", "Smith");
		Student s2 = new Student(67890, "Jane", "Smith");
		Student s3 = new Student(13579, "Adam", "Smith");
		Student s4 = new Student(67890, "Thee", "DD");
		// if we only have equals () with ID - this will be added in set
		// but if student has hashCode() as well with id - you won't see in in SET
		/*
		public boolean containsKey(Object key) {
            return getNode(hash(key), key) != null;
        }
		 */
		collection.add(s1);
		collection.add(s1);
		collection.add(s2);
		collection.add(s3);
		collection.add(s4);
		for (Student student : collection) {
			System.out.println(student.getFname());
		}
	}


}