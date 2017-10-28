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
// Java program to illustrate join() method in Java

public class JoinDemo implements Runnable {
	public static void main(String args[]) throws Exception {
		Thread t = new Thread(new JoinDemo());
		t.start();

		// Waits for 1000ms this thread to die.
		t.join(1000);

		System.out.println("\nJoining after 1000" +
				" mili seconds: \n");
		System.out.println("Current thread: " +
				t.getName());


		// Checks if this thread is alive
		System.out.println("Is alive? " + t.isAlive());
	}

	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Current thread: "
				+ t.getName());

		// checks if current thread is alive
		System.out.println("Is Alive? "
				+ t.isAlive());
	}
}