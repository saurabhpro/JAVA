/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list.arraylist;

import list.arraylist.model.Emp;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Saurabh on 9/6/2015.
 */
public class SimpleDemoEmp {

	private final ArrayList<Emp> al;

	//Initializer Constructor
	private SimpleDemoEmp() {
		al = new ArrayList<>();
		al.add(new Emp(1001, "Ram"));
		al.add(new Emp(1002, "Shyam"));
		al.add(new Emp(1003, "Hero"));
		al.add(new Emp(1004, "Tom"));
	}

	public static void main(String[] args) {
		SimpleDemoEmp aOb = new SimpleDemoEmp();
		aOb.ownClassArrayListIterator();
		aOb.ownClassRemoveWithEquals();
	}

	private void ownClassArrayListIterator() {

		Iterator<Emp> i = al.iterator();

		while (i.hasNext()) {
			Emp z = i.next();
			System.out.println(z.id + " " + z.name);
			if (z.id == 1004)
				i.remove();
		}
		System.out.println();

		//Re-assign the iterator
		i = al.iterator();

		while (i.hasNext()) {
			Emp p = i.next();
			System.out.println(p.id + " " + p.name);
		}
	}

	private void ownClassRemoveWithEquals() {
		/*
		 * if you want to perform any operation on any class object in ArrayList then that class (Say java.list.arraylist.deadlock.Emp)
		 * must override the equal(Object) method of the object class.
		 */

		Iterator<Emp> i = al.iterator();

		System.out.println("Before Removing Element");
		while (i.hasNext()) {
			Emp z = i.next();
			//next returns Object, as we already fixed type to <java.list.arraylist.deadlock.Emp> in Iterator we dont need to downcast it
			//else   java.list.arraylist.deadlock.Emp z = (java.list.arraylist.deadlock.Emp)i.next();
			System.out.println(z.id + " " + z.name);
		}

		/*
		 * Q. what does remove() need equal(Object) for?
		 * remove(Object) needs some mechanism to search through the list and find the object that's passed to it in the argument,
		 * to search through the list it must check for equality hence equals(Object)
		 *
		 * if you don't override equals(object) then by default object's equals(Object) will run and that checks
		 * only for the references of the objects, since we are passing a new object as argument,
		 * the reference wont be same and hence nothing will be deleted
		 */

		Emp e = new Emp(1004, "Tom");

		System.out.println("\nremove(e) returned " + al.remove(e));
		//prints true if removed else false if not or if null as arg

		System.out.println("\nAfter Removing Element");
		i = al.iterator();
		while (i.hasNext()) {
			Emp p = i.next();
			System.out.println(p.id + " " + p.name);
		}
	}
}
