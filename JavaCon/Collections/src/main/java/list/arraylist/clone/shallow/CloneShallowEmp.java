/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list.arraylist.clone.shallow;

import java.util.ArrayList;

/**
 * Created by Saurabh on 9/6/2015.
 */

class EmpClone implements Cloneable {
	final int x;

	EmpClone(int x) {
		this.x = x;
	}
}

public class CloneShallowEmp {
	public static void main(String[] args) {
		ArrayList<EmpClone> al = new ArrayList<>();
		al.add(new EmpClone(1001));
		al.add(new EmpClone(1002));
		al.add(new EmpClone(1003));
		al.add(new EmpClone(1004));

		System.out.println("Actual ArrayList");
		for (EmpClone e : al)
			System.out.println(e.x);

		ArrayList<EmpClone> copy = (ArrayList<EmpClone>) al.clone();
		System.out.println("Cloned ArrayList");
		for (EmpClone e : copy)
			System.out.println(e.x);

		EmpClone e1 = al.get(0);
		EmpClone e2 = copy.get(0);

		// copy.set(0,(java.list.arraylist.clone.shallow.EmpClone)al.get(0));

		if (e1 == e2) System.out.println("Shallow");
		if (al != copy) System.out.println("Clone");
	}
}
