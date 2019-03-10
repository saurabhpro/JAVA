/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package basics.synchronization;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A CountDownLatch is initialized with a given count. This count is decremented by calls to the countDown() method.
 * Threads waiting for this count to reach zero can call one of the await() methods.
 * Calling await() blocks the thread until the count reaches zero.
 */
public class CountDownLatchSimple {
	public static void main(String[] args) {

		// concurrency construct that allows one or more threads to wait for a given set of operations to complete.
		CountDownLatch latch = new CountDownLatch(3);

		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 3; i++) {
			// the passed latch is copied
			executor.execute(new Processor(latch));     // since we don't care about result Future so no submit()
		}

		try {
			// Causes the current thread to wait until the latch has counted down to zero
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Completed.");
	}

	static class Processor implements Runnable {
		private CountDownLatch latch;   // thread safe class

		public Processor(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			System.out.println("Started.");

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			latch.countDown();  // decrement count by 1 of the original latch
		}
	}

}