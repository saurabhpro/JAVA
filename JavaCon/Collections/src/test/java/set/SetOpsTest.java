/*
 * Copyright (c) 2018 Saurabh Kumar
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