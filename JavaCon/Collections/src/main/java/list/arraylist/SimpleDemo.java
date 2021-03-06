/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list.arraylist;

import java.util.ArrayList;

/**
 * Created by Saurabh on 9/6/2015.
 */
public class SimpleDemo {
	private static void basicOperationShow() {
		ArrayList<Integer> al = new ArrayList<>();

		//takes repeated values unlike Sets
		int[] ar = new int[]{1, -1, 2, 2, -3, 3, 4, 5};

		for (int anAr : ar)
			al.add(anAr);


		Object[] ob;                                //= new Object[al.size()]; redundant code
		ob = al.toArray();

		//  for(int i = 0; i<ob.length;i++)
		for (Object anOb : ob) {
			Integer z = (Integer) anOb;
			System.out.print(z + " ");
		}

		System.out.println();
		for (Integer i : al) {
			System.out.print(i + " ");     //intValues() unboxing is unnecessary, so can safely be removed
			//Explicit unwrapping of wrapper primitive type, Unboxing is not needed from java 1.5
		}
	}

	private static void selfPassedArrayList() {
		ArrayList<ArrayList> al = new ArrayList<>();

		ArrayList<String> als = new ArrayList<>();
		System.out.println(al.size());      //0

		als.add("a");
		als.add("b");
		als.add("c");

		al.add(als);
		al.add(als);
		System.out.println(al.size());      //2 only

		System.out.println(al);
		/*
		    [[a, b, c], (this Collection)]
         */
	}

	public static void main(String[] args) {
	    /* Show basic toArray() operations on ArrayList*/
		basicOperationShow();
		selfPassedArrayList();
	}
}
