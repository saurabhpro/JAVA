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
