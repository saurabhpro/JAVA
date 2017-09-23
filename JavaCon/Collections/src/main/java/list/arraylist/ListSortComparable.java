/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package list.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/*
 * Created by Saurabh on 9/6/2015.
 */

/**
 * sort() of collections class can sort the objects of those classes which are implementing Comparable interfaces by default
 */
class Empl implements Comparable<Empl> {
	final int salary;
	final String name;

	Empl(String str, int sal) {
		name = str;
		salary = sal;
	}

	int getSalary() {
		return salary;
	}

    /*not implemented comaparable till now*/
	//compile time error ayega if we run the program without below code

    /*public int compareTo(Object o) {  return 0;  } //Cant;t be used as we havew used type bounding with main.java.list.arraylist.Empl */


	/**
	 * Compares this object with the specified object for parts.  Returns a
	 * negative integer, zero, or a positive integer as this object is less
	 * than, equal to, or greater than the specified object.
	 * <p>
	 * <p>It is strongly recommended, but <i>not</i> strictly required that
	 * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
	 * class that implements the <tt>Comparable</tt> interface and violates
	 * this condition should clearly indicate this fact.  The recommended
	 * language is "Note: this class has a natural ordering that is
	 * inconsistent with equals."
	 * <p>
	 *
	 * @param o the object to be compared.
	 * @return a negative integer, zero, or a positive integer as this object
	 * is less than, equal to, or greater than the specified object.
	 * @throws NullPointerException if the specified object is null
	 * @throws ClassCastException   if the specified object's type prevents it
	 *                              from being compared to this object.
	 */
	@Override
	public int compareTo(Empl o) {
		Objects.nonNull(o);

		System.out.println("Inside compareTo ...sortin");

		return Integer.compare(this.salary, o.salary);
	}
}

public class ListSortComparable {
	private final List<Empl> list = new ArrayList<>();

	private ListSortComparable() {
		list.add(new Empl("Raam", 3000));
		list.add(new Empl("John", 6000));
		list.add(new Empl("Chris", 3000));
		list.add(new Empl("Tom", 4000));
	}

	public static void main(String[] args) {
		ListSortComparable lOb = new ListSortComparable();
		Collections.sort(lOb.list);

		System.out.println("Sorted List Entries");
		for (Empl e : lOb.list)
			System.out.println(e.salary + " " + e.name);

		Empl e1 = Collections.max(lOb.list);
		Empl e2 = Collections.min(lOb.list);

		System.out.println("Max Salary " + e1.salary);
		System.out.println("Min Salary " + e2.salary);
	}
}
