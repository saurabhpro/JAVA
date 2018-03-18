/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list.synchronizedlist.copyonwrite;

import java.util.concurrent.CopyOnWriteArrayList;

class Thread2 implements Runnable {
	private final CopyOnWriteArrayList<String> al;

	Thread2(CopyOnWriteArrayList<String> al) {
		this.al = al;
	}

	@Override
	public void run() {
		try {
			al.add("First");
			al.add("Second");
			al.add("Third");

			System.out.println("T2 " + al);
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
	}
}
