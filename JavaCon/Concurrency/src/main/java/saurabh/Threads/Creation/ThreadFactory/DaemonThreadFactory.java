package saurabh.Threads.Creation.ThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by Saurabh on 10/21/2015. To create a Daemon thread we need a special interface called ThreadFactory which
 * has a single method Thread newThread(Runnable r); which returns a Thread. Thread class has many methods one such is
 * setDaemon(boolean)
 * <p>
 * Any method in Executors class can be passed a ThreadFactory, as all methods are overloaded
 */

class DaemonThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		// t.setName("DaemonThread-");
		return t;
	}
}

class DaemonFromThreadFactory implements Runnable {
	public static void main(String[] args) throws InterruptedException {
		/**
		 argument of newCatchedThreadPool is overloaded to take a ThreadFactory object
		 this is the advantage of creating custom thread using ThreadFactory
		 */
		ExecutorService service = Executors.newCachedThreadPool(new DaemonThreadFactory());     //overloaded ()

		for (int i = 0; i < 5; i++)
			service.execute(new DaemonFromThreadFactory());

		System.out.println("All Daemons Started");
		TimeUnit.MILLISECONDS.sleep(150);   //change this to see the difference in output
	}

	@Override
	public void run() {
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			} catch (InterruptedException e) {
				System.out.println("sleep() Interrupted");
			}
		}
	}
}

