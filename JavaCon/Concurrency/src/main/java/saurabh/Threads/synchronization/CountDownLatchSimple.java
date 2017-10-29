/*
 * Copyright 2017 Saurabh Kumar 29/10/17 9:25 AM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package saurabh.Threads.synchronization;

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