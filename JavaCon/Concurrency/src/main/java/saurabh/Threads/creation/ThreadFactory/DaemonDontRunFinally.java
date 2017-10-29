/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package saurabh.Threads.creation.ThreadFactory;

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

	private void runThread() {
		Thread t = new Thread(new DaemonDontRunFinally());
		t.setDaemon(true);
		/*
		 * if we comment the above line we will see that finally always runs
		 * but for daemon thread they don't (WHY?)
		 *
		 * because Daemon thread are not reliable, they are terminated even alive once main() exits,
		 * so the compiler privileges of graceful exit is not given to them.
		 */
		t.start();
	}
}
