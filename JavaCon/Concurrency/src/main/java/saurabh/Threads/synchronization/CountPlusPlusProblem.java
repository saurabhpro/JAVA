/*
 * Copyright 2017 Saurabh Kumar 29/10/17 8:32 AM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
