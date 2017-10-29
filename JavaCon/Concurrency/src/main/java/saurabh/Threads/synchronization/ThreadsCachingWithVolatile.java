/*
 * Copyright 2017 Saurabh Kumar 29/10/17 8:30 AM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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