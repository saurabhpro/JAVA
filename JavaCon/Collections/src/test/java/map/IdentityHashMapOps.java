/*
 * Copyright (c) 2018 Saurabh Kumar
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