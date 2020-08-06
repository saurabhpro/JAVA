/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list.synchronizedlist.problem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Saurabh on 9/13/2015.
 * java.util.ConcurrentModificationException
 * When java.list.synchronizedlist.Thread1 comes back, it will throw  this Exception
 */
@SuppressWarnings("unchecked")
class ArrayListThread1 implements Runnable {
	private final ArrayList<String> al;

	ArrayListThread1(ArrayList<String> al) {
		this.al = al;
	}

	@Override
	public void run() {
		Iterator i = al.iterator();

		//or simply do = for (String x : al)
		//noinspection WhileLoopReplaceableByForEach
		while (i.hasNext()) {
			try {
				String str = (String) i.next();
				System.out.println("Name: " + str);

				Thread.sleep(2000);
			} catch (Exception e) {
				{
					System.out.println("Explain Ready = " + e);
					System.exit(0);
				}
			}
		}
	}
}
