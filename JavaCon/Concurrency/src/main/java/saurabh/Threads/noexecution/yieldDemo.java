/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Threads.noexecution;
// Java program to illustrate yield() method in Java

/**
 * yield() basically means that the thread is not doing anything particularly important and
 * if any other threads or processes need to be run, they should run. Otherwise,
 * the current thread will continue to run.
 */
public class yieldDemo {

	// MyThread extending Thread
	static class MyThread extends Thread {
		public void run() {
			for (int i = 0; i < 5; i++)
				System.out.println("A" + Thread.currentThread().getName() + " in control");
		}
	}

	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		t.setPriority(6);   // since only equal or higher priority threads gets picked up upon yeild

		for (int i = 0; i < 5; i++) {

			if (i == 2)
				// Control passes to child thread
				Thread.yield();

			// After execution of child Thread
			// main thread takes over
			System.out.println(Thread.currentThread().getName()
					+ " in control");
		}
	}
}

/*
Once a thread has executed yield method and there are many threads with same priority is waiting for processor, then we can't specify which thread will get execution chance first.
The thread which executes the yield method will enter in the Runnable state from Running state.
Once a thread pauses its execution, we can't specify when it will get chance again it depends on thread scheduler.
Underlying platform must provide support for preemptive scheduling if we are using yield method.
 */