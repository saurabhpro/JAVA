/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list.synchronizedlist.copyonwrite;


import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Saurabh on 9/13/2015.
 */

class Thread1 implements Runnable {
	private final CopyOnWriteArrayList<String> al;

	Thread1(CopyOnWriteArrayList<String> al) {
		this.al = al;
	}

	@Override
	public void run() {

		for (String anAl : al) {
			try {
				System.out.println("Name: " + anAl);

				Thread.sleep(200);
			} catch (Exception e) {
				{
					System.out.println("Explain Ready = " + e);
					System.exit(0);
				}
			}
		}
	}
}
