/*
 * Copyright (c) 2018 Saurabh Kumar
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
