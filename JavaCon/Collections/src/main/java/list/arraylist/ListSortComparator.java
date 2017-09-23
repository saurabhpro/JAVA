package list.arraylist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Saurabh on 9/6/2015.
 */

class EmplComp {
	int salary;
	String name;

	EmplComp(String str, int sal) {
		name = str;
		salary = sal;
	}

	int getSalary() {
		return salary;
	}

    /*not implemented comaparable till now*/
	//compile time error ayega if we run the program without below code
}

class MySalaryComp implements Comparator<EmplComp> {
	/**
	 * Compares its two arguments for parts.  Returns a negative integer,
	 * zero, or a positive integer as the first argument is less than, equal
	 * to, or greater than the second.<p>
	 * <p>
	 * In the foregoing description, the notation
	 * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
	 * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
	 * <tt>0</tt>, or <tt>1</tt> according to whether the value of
	 * <i>expression</i> is negative, zero or positive.<p>
	 * <p>
	 * The implementor must ensure that <tt>sgn(compare(x, y)) ==
	 * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
	 * implies that <tt>compare(x, y)</tt> must throw an exception if and only
	 * if <tt>compare(y, x)</tt> throws an exception.)<p>
	 * <p>
	 * The implementor must also ensure that the relation is transitive:
	 * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
	 * <tt>compare(x, z)&gt;0</tt>.<p>
	 * <p>
	 * Finally, the implementor must ensure that <tt>compare(x, y)==0</tt>
	 * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
	 * <tt>z</tt>.<p>
	 * <p>
	 * It is generally the case, but <i>not</i> strictly required that
	 * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
	 * any comparator that violates this condition should clearly indicate
	 * this fact.  The recommended language is "Note: this comparator
	 * imposes orderings that are inconsistent with equals."
	 *
	 * @param o1 the first object to be compared.
	 * @param o2 the second object to be compared.
	 * @return a negative integer, zero, or a positive integer as the
	 * first argument is less than, equal to, or greater than the
	 * second.
	 * @throws NullPointerException if an argument is null and this
	 *                              comparator does not permit null arguments
	 * @throws ClassCastException   if the arguments' types prevent them from
	 *                              being compared by this comparator.
	 */
	@Override
	public int compare(EmplComp o1, EmplComp o2) {
		if (o1.getSalary() > o2.getSalary())
			return 1;
		return -1;
	}
}

class MyNameComp implements Comparator<EmplComp> {

	@Override
	public int compare(EmplComp o1, EmplComp o2) {
		return o1.name.compareTo(o2.name);
	}
}


public class ListSortComparator {
	List<EmplComp> list = new ArrayList<>();

	ListSortComparator() {
		list.add(new EmplComp("Raam", 3000));
		list.add(new EmplComp("John", 6000));
		list.add(new EmplComp("Chris", 2000));
		list.add(new EmplComp("Tom", 4000));
	}

	public static void main(String[] args) {
		ListSortComparator lOb = new ListSortComparator();
		lOb.list.sort(new MySalaryComp());

		System.out.println("Sorted List Entries Based on Salary");
		for (EmplComp e : lOb.list)
			System.out.println(e.salary + " " + e.name);

		//instead of Collections.sort use List.sort directly
		lOb.list.sort(new MyNameComp());

		System.out.println("Sorted List Entries Based on Name");
		for (EmplComp e : lOb.list)
			System.out.println(e.name + " " + e.salary);
	}
}
