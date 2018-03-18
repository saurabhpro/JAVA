/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.model;

import java.util.Arrays;
import java.util.List;

public class DataProvider {

	public static final List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);


	private static final Person p1 = new Person("Alice", "", 23);
	private static final Person p2 = new Person("Brian", "", 56);
	private static final Person p3 = new Person("Chelsea", "", 46);
	private static final Person p4 = new Person("David", "", 28);
	private static final Person p5 = new Person("Erica", "", 37);
	private static final Person p6 = new Person("Francisco", "", 18);

	private static final Department d1 = new Department("IT", 8);
	private static final Department d2 = new Department("Tech", 2);

	private static final Employee e1 = new Employee(p1, d1, 2_800_000);
	private static final Employee e2 = new Employee(p2, d1, 1_800_000);
	private static final Employee e3 = new Employee(p3, d1, 1_850_000);
	private static final Employee e4 = new Employee(p5, d2, 7_800_000);
	private static final Employee e5 = new Employee(p5, d2, 7_800_001);


	public static List<Person> getYoungPersonList() {
		return Arrays.asList(p1, p2, p3, p4, p5, p6);
	}

	public static List<Employee> getEmplolyeeList() {
		return Arrays.asList(e1, e2, e3, e4, e5);
	}

}
