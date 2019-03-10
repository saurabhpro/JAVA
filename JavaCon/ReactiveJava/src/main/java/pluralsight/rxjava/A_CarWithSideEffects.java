/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava;

import static java.lang.System.out;

public class A_CarWithSideEffects {

	private int remainingFuel;

	public A_CarWithSideEffects(int startingFuel) {
		this.remainingFuel = startingFuel;
	}

	private static void safeSleep(int milliseconds) {
		try {
			out.printf("%1s - Something stole your thread!  Your are going to sleep!\n", Thread.currentThread().getName());

			Thread.sleep(milliseconds);
		} catch (InterruptedException ignored) {
		}
	}

	public static void main(String[] args) {

		try {
			A_CarWithSideEffects c = new A_CarWithSideEffects(10);

			// Create thread 1
			Thread t1 = new Thread(() -> {

				out.print("Thread 1 started...\n");

				if (c.hasFuel(10)) {

					out.print("Thread 1 - Car has the fuel to move 10 units!\n");

					// We have the fuel...move!  But first, exagerage the possible problem
					safeSleep(2000);

					c.move(10);

					out.printf("Thread 1 - I move the %d units car!\n", 10);
				}

			}, "Thread #1");

			// Create thread 2
			Thread t2 = new Thread(() -> {

				out.print("Thread 2 started...\n");

				if (c.hasFuel(5)) {

					out.print("Thread 2 - Car has the fuel to move 5 units!\n");

					// We have the fuel...move quickly
					c.move(5);

					out.printf("Thread 2 - I moved the car %d units!\n", 5);
				}

			}, "Thread #2");

			// Start both threads...give thread 1 a chance to go first
			t1.start();
			Thread.sleep(100);
			t2.start();

			// Assuming we get here...join the threads before stopping
			t1.join();
			t2.join();
		} catch (InterruptedException ignored) {
		}

		System.exit(0);
	}

	public synchronized boolean hasFuel(int distance) {
		return distance <= remainingFuel;
	}

	public synchronized void move(int distance) {

		if (distance > remainingFuel) {
			throw new IllegalStateException(String.format("The car doesn't have the fuel to move %1s units.", distance));
		}
		remainingFuel -= distance;
	}
}


/*
Thread 1 started...
Thread 1 - Car has the fuel to move 10 units!
Thread #1 - Something stole your thread!  Your are going to sleep!
Thread 2 started...
Thread 2 - Car has the fuel to move 5 units!
Thread 2 - I moved the car 5 units!
Exception in thread "Thread #1" java.lang.IllegalStateException: The car doesn't have the fuel to move 10 units.
	at pluralsight.rxjava.CarWithSideEffects.move(A_CarWithSideEffects.java:94)
	at pluralsight.rxjava.CarWithSideEffects.lambda$main$0(A_CarWithSideEffects.java:49)
	at java.base/java.lang.Thread.run(Thread.java:844)
 */