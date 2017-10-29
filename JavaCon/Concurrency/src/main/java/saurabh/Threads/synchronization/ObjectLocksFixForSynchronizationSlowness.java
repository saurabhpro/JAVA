/*
 * Copyright 2017 Saurabh Kumar 29/10/17 8:55 AM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package saurabh.Threads.synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ObjectLocksFixForSynchronizationSlowness {

	private final Object lock1 = new Object();  // separate lock objects is a good practice
	private final Object lock2 = new Object();

	private final Random random = new Random();
	private final List<Integer> list1 = new ArrayList<>();
	private final List<Integer> list2 = new ArrayList<>();

	public static void main(String[] args) {
		ObjectLocksFixForSynchronizationSlowness ob = new ObjectLocksFixForSynchronizationSlowness();
		ob.doWork();
	}

	private void stageOne() {

		// lock object is nothing but the hashcode ?
		// use this to lock with this class - and fuck you code
		synchronized (lock1) {
			sleepHere();
			list1.add(random.nextInt(100));
		}

	}

	private void stageTwo() {

		synchronized (lock2) {
			sleepHere();
			list2.add(random.nextInt(100));
		}

	}

	private void sleepHere() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	private void doWork() {
		System.out.println("Starting ...");

		long start = System.currentTimeMillis();

		Thread t1 = new Thread(this::process);
		Thread t2 = new Thread(this::process);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start));
		System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
	}
}
 