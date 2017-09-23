/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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

		// copy.set(0,(main.java.list.arraylist.clone.shallow.EmpClone)al.get(0));

		if (e1 == e2) System.out.println("Shallow");
		if (al != copy) System.out.println("Clone");
	}
}
