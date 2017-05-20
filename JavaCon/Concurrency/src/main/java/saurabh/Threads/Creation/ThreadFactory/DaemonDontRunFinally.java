package saurabh.Threads.Creation.ThreadFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Saurabh on 10/21/2015. one thing more to notice about Daemon threads is that they dont get to execute
 * their finally blocks [which as we know executes SURELY for User thread exceptions]
 */

public class DaemonDontRunFinally implements Runnable {

	public static void main(String[] args) {
		new DaemonDontRunFinally().runThread();
	}

	@Override
	public void run() {
		try {
			System.out.println("starting a daemon");
			TimeUnit.MILLISECONDS.sleep(100);

		} catch (InterruptedException e) {
			System.out.println("sleep() interrupted");
		} finally {
			System.out.println("finally should run always??");
		}
	}

	void runThread() {
		Thread t = new Thread(new DaemonDontRunFinally());
		t.setDaemon(true);
		/**
		 * if we comment the above line we will see that finally always runs
		 * but for daemon thread they don't (WHY?)
		 *
		 * because Daemon thread are not reliable, they are terminated even alive once main() exits,
		 * so the compiler privileges of graceful exit is not given to them.
		 */
		t.start();
	}
}
