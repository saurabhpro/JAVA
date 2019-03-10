/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package basics.pools;

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
