/*
 * Copyright 2017 Saurabh Kumar 29/10/17 9:07 AM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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