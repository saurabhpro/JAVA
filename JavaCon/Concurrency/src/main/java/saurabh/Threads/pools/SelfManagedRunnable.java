/*
 * Copyright 2017 Saurabh Kumar 29/10/17 9:04 AM
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

/**
 * Created by Saurabh on 10/21/2015.
 */
public class SelfManagedRunnable implements Runnable {
	private int countDown = 4;

	private SelfManagedRunnable() {
		// Thread t = new Thread(this);
		//t.start();
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 3; i++) {
			// Executes the given command at some time in the future.  The command
			// may execute in a new thread, in a pooled thread, or in the calling
			// thread, at the discretion of the {@code Executor} implementation.

			executorService.execute(new SelfManagedRunnable());     // from Executor interface
		}

		executorService.shutdown();
	}

	@Override
	public String toString() {
		return Thread.currentThread() + " : " + countDown;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(this);
			if (--countDown == 0) return;
		}
	}

}
