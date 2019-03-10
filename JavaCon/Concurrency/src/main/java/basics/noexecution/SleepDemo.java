/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package basics.noexecution;

// Java program to illustrate sleep() method in Java

public class SleepDemo implements Runnable {

	public static void main(String[] args) {
		Thread t = new Thread(new SleepDemo());

		// call run() function
		t.start();

		Thread t2 = new Thread(new SleepDemo());

		// call run() function
		t2.start();
	}

	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println(Thread.currentThread().getName() + "  " + i);
			try {
				// thread to sleep for 1000 milliseconds
				Thread.sleep(1000);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}

/*
Thread-1  0
Thread-0  0
Thread-1  1
Thread-0  1
Thread-0  2
Thread-1  2
Thread-0  3
Thread-1  3
 */
