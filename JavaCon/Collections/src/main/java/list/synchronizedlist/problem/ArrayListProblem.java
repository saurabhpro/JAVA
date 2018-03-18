/*
 * Copyright (c) 2018 Saurabh Kumar
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
