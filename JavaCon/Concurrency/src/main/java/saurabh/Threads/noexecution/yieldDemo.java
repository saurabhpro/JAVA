/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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