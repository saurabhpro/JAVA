/*
 * Copyright 2017 Saurabh Kumar 29/10/17 9:35 AM
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
import java.util.concurrent.TimeUnit;

public class CountDownLatchWithWaiter {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);

		Waiter waiter = new Waiter(latch);
		Decremental decremental = new Decremental(latch);

//		new Thread(waiter).start();
//		new Thread(decremental).start();
//
//		try {
//			Thread.sleep(4000); // can use executor here as well
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		// add for execution
		executorService.execute(waiter);
		executorService.execute(decremental);

		try {
			executorService.awaitTermination(4000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.exit(99);
	}

	static public class Waiter implements Runnable {

		CountDownLatch latch = null;

		public Waiter(CountDownLatch latch) {
			this.latch = latch;
		}

		public void run() {
			try {
				latch.await();  // awaits till countdown is 0
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Waiter Released");
		}
	}

	static public class Decremental implements Runnable {

		CountDownLatch latch = null;

		public Decremental(CountDownLatch latch) {
			this.latch = latch;
		}

		public void run() {
			try {
				System.out.println("In Decrement");
				Thread.sleep(1000);
				this.latch.countDown();

				System.out.println("In Decrement");
				Thread.sleep(1000);
				this.latch.countDown();

				System.out.println("In Decrement");
				Thread.sleep(1000);
				this.latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
