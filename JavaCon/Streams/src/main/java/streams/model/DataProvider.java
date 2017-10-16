/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package streams.model;

import java.util.Arrays;
import java.util.List;

public class DataProvider {

	public static List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);


	public static Person p1 = new Person("Alice", "", 23);
	public static Person p2 = new Person("Brian", "", 56);
	public static Person p3 = new Person("Chelsea", "", 46);
	public static Person p4 = new Person("David", "", 28);
	public static Person p5 = new Person("Erica", "", 37);
	public static Person p6 = new Person("Francisco", "", 18);

	public static Department d1 = new Department("IT", 8);
	public static Department d2 = new Department("Tech", 2);

	public static Employee e1 = new Employee(p1, d1, 2_800_000);
	public static Employee e2 = new Employee(p2, d1, 1_800_000);
	public static Employee e3 = new Employee(p3, d1, 1_850_000);
	public static Employee e4 = new Employee(p5, d2, 7_800_000);
	public static Employee e5 = new Employee(p5, d2, 7_800_001);


	public static List<Person> getYoungPersonList() {
		return Arrays.asList(p1, p2, p3, p4, p5, p6);
	}

	public static List<Employee> getEmplolyeeList() {
		return Arrays.asList(e1, e2, e3, e4, e5);
	}

}
