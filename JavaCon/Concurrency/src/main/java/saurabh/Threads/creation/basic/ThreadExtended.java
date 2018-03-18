/*
 * Copyright (c) 2018 Saurabh Kumar
 */

/*
 * Created by Saurabh on 10/21/2015.
 */
package saurabh.Threads.creation.basic;

public class ThreadExtended extends Thread {
	private static int threadCount = 0;
	private int countDown = 3;

	private ThreadExtended() {
		//     super(Integer.toString(++threadCount));
		start();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++)
			new ThreadExtended();
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(this);
			if (countDown-- == 0) return;
		}
	}

	@Override
	public String toString() {
		return getName() + "(" + countDown + ")";
	}
}
