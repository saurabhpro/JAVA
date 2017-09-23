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

import list.arraylist.model.Emp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Saurabh on 9/6/2015.
 */
public class ToArrayAndAsList {

	private static void ArrayListToArray() {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("String 1");
		arrayList.add("String 2");
		arrayList.add("String 3");
		arrayList.add("String 4");

		String[] ar = new String[arrayList.size()];

		for (int j = 0; j < arrayList.size(); ++j)
			ar[j] = arrayList.get(j);

		for (String k : ar)
			System.out.print(k + " ");
	}

	private static void ArrayListArrayToList() {
		String[] citynames = {"Agra", "Mysore", "chandigarh", "Bhopal"};
		List<String> list = Arrays.asList(citynames);

		ArrayList<String> cityList = new ArrayList<>(list);

		cityList.add("City 3");
		cityList.add("City 4");

		for (String str : cityList)
			System.out.print(str + " ");
	}

	private static void ArrayListToArrayPassedAsArg() {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("String 1");
		arrayList.add("String 2");
		arrayList.add("String 3");
		arrayList.add("String 4");

		String[] ar = new String[arrayList.size()];

		arrayList.toArray(ar);

		System.out.println("Created Array Content:");
		for (String str : ar)
			System.out.print(str + " ");

		System.out.println();
		for (String str : arrayList)
			System.out.print(str + " ");
	}

	private static void MyArrayListToArrayEmp() {
		ArrayList<Emp3> arrayList = new ArrayList<>();
		arrayList.add(new Emp3(1001));
		arrayList.add(new Emp3(1002));
		arrayList.add(new Emp3(1003));
		arrayList.add(new Emp3(1004));

		Emp3[] ar = new Emp3[arrayList.size()];
		arrayList.toArray(ar);

		System.out.println("Created Array Content:");
		for (Emp3 e : ar)
			System.out.print(e.x + " ");
	}

	public static void main(String[] args) {
		System.out.println("ArrayList toArray for String type.");
		ArrayListToArray();
		System.out.println("\n\nArrayList Array asList for String type");
		ArrayListArrayToList();
		System.out.println("\n\nArrayList toArray(arg destination array)");
		ArrayListToArrayPassedAsArg();
		System.out.println("\n\nArrayList toArray using our own class main.java.list.arraylist.deadlock.Emp3");
		MyArrayListToArrayEmp();
	}
}
