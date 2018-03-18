/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Threads.synchronization;

import java.util.Scanner;


public class ThreadsCachingWithVolatile {

	public static void main(String[] args) {
		Processor pro = new Processor();
		pro.start();

		// Wait for the enter key
		new Scanner(System.in).nextLine();

		pro.shutdown();
	}

	static class Processor extends Thread {

		// saying volatile means don't cache
		private volatile boolean running = true;

		@Override
		public void run() {

			// runs in separate thread than Main -
			// hence the running variable might be cached for it
			while (running) {
				System.out.println("Running in " + Processor.currentThread());
				// Running in Thread[Thread-0,5,main]

				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		void shutdown() {
			running = false;
			System.out.println("Running in " + Processor.currentThread());
			// Running in Thread[main,5,main]
		}
	}

}