/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package list.synchronizedlist.problem;

import java.util.ArrayList;

public class ArrayListProblem {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");

		try {
			ArrayListThread1 arrayListThread1 = new ArrayListThread1(arrayList);
			Thread t1 = new Thread(arrayListThread1);

			ArrayListThread2 arrayListThread2 = new ArrayListThread2(arrayList);
			Thread t2 = new Thread(arrayListThread2);

			t1.setPriority(10);
			t2.setPriority(1);

			t1.start();
			t2.start();
		} catch (Exception e) {
			System.out.println("Exception : " + e);

		}

		System.out.println("Final ArrayList: " + arrayList);
	}
}
