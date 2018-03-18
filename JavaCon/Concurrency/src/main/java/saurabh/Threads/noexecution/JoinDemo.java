/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Threads.noexecution;
// Java program to illustrate join() method in Java

public class JoinDemo implements Runnable {
	public static void main(String args[]) throws Exception {

		Thread t = new Thread(new JoinDemo());
		System.out.println(Thread.currentThread() + " started " + t.getName());
		t.start();

		// Main thread waits at most this much milliseconds for this thread to die
		// Waits for 1000ms this thread to die.
		t.join(1000);

		System.out.println("\nJoining after 1000 mili seconds: \n");
		System.out.println("Current thread: " + t.getName());


		// Checks if this thread is alive
		System.out.println("Is alive? " + t.isAlive());

		// Main thread exits but child will end soon
	}

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Current thread: " + t.getName());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// checks if current thread is alive
		System.out.println("O wait Im still Is Alive? " + t.isAlive());


	}
}

/*
Note:

If any executing thread t1 calls join() on t2 i.e; t2.join() immediately t1 will enter into waiting state until t2 completes its execution.
Giving a timeout within join(), will make the join() effect to be nullified after the specific timeout.
 */