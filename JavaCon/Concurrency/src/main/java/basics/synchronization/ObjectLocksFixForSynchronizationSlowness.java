/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package basics.synchronization;

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
 