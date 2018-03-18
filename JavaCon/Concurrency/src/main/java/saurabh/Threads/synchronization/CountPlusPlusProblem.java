/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Threads.synchronization;

import java.util.stream.IntStream;

public class CountPlusPlusProblem {

	private int count = 0;  // we can also do AtomicInteger but that won't solve volatile (more!)

	public static void main(String[] args) {
		CountPlusPlusProblem countPlusPlusProblem = new CountPlusPlusProblem();
		countPlusPlusProblem.doWork();
	}

	// make this operation atomic with intrinsic lock with synchronized
	private synchronized void increment() {
		// count++ is a three step process - hence synchronized
		count++;
	}

	// make it synchronized to work
	private void incrementBasic() {
		// count++ is a three step process - hence will fail
		count++;
	}

	private void doWork() {
		Thread thread1 = new Thread(() -> IntStream.range(0, 10000).forEach(i -> increment()));
		thread1.start();

		Thread thread2 = new Thread(() -> IntStream.range(0, 10000).forEach(i -> incrementBasic()));
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Count is: " + count);
	}
}
