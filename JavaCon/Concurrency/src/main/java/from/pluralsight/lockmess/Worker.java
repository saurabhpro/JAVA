/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package from.pluralsight.lockmess;

import java.util.Timer;
import java.util.TimerTask;

public class Worker extends Thread {

	private final Object lock = new Object();
	private volatile boolean quittingTime = false;

	public static void main(String... args) throws InterruptedException {

		final Worker worker = new Worker();
		worker.start();

		Timer t = new Timer(true); // Daemon thread
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				worker.keepWorking();
			}

		}, 500);

		Thread.sleep(400);
		worker.quit();
	}

	@Override
	public void run() {
		while (!quittingTime) {
			working();
			System.out.println("Still working...");
		}

		System.out.println("Coffee is good !");
	}

	private void working() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException ignored) {
		}
	}

	private synchronized void quit() throws InterruptedException {
		synchronized (lock) {
			quittingTime = true;
			System.out.println("Calling join");
			join();

			System.out.println("Back from join");
		}
	}

	private synchronized void keepWorking() {
		synchronized (lock) {
			quittingTime = false;
			System.out.println("Keep working");
		}
	}
}
