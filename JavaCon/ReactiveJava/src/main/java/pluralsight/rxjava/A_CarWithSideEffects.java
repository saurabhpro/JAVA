/*
 * Copyright 2017 Saurabh Kumar 29/10/17 7:14 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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

				out.printf("Thread 1 started...\n");

				if (c.hasFuel(10)) {

					out.printf("Thread 1 - Car has the fuel to move 10 units!\n");

					// We have the fuel...move!  But first, exagerage the possible problem
					safeSleep(2000);

					c.move(10);

					out.printf("Thread 1 - I move the 10 units car!\n");
				}

			}, "Thread #1");

			// Create thread 2
			Thread t2 = new Thread(() -> {

				out.printf("Thread 2 started...\n");

				if (c.hasFuel(5)) {

					out.printf("Thread 2 - Car has the fuel to move 5 units!\n");

					// We have the fuel...move quickly
					c.move(5);

					out.printf("Thread 2 - I moved the car 5 units!\n");
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