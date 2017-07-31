package saurabh.Threads;

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

		for (int i = 0; i < 3; i++)
			// new ThreadRunnable();
			executorService.execute(new SelfManagedRunnable());

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
