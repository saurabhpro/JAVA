/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Threads.pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class ExecutorsThreadPoolRecycle {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 5; i++) {
			// Submits a value-returning task for execution and returns a
			// Future representing the pending results of the task.
			Future<?> submitted = executor.submit(new Processor(i));
		}

		// previously submittedtasks are executed, but no new tasks will be accepted.
		executor.shutdown();

		System.out.println("All tasks submitted.");

		try {

			// Blocks until all tasks have completed execution after a shutdown
			// request, or the timeout occurs, or the current thread is
			// interrupted, whichever happens first.

			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException ignored) {
		}

		System.out.println("All tasks completed.");
	}

	static class Processor implements Runnable {

		private int id;

		public Processor(int id) {
			this.id = id;
		}

		public void run() {
			System.out.println("Starting: " + id);

			try {
				Thread.sleep(5000);
			} catch (InterruptedException ignored) {
			}

			System.out.println("Completed: " + id);
		}
	}
}