/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package saurabh.Threads;

/**
 * Created by saurabhkumar on 29/07/17.
 */
public class RunnableThreadDemo {
	public static void main(String[] args) {
		boolean isDaemon = args.length != 0;

		//noinspection Convert2Lambda
		Runnable r = new Runnable() {
			@Override
			public void run() {
				Thread thd = Thread.currentThread();
				while (true)
					System.out.printf("%s is %salive and in %s " +
									"state%n",
							thd.getName(),
							thd.isAlive() ? "" : "not ",
							thd.getState());
			}
		};

		Thread t1 = new Thread(r, "thd1");

		if (isDaemon)
			t1.setDaemon(true);

		System.out.printf("%s is %salive and in %s state%n",
				t1.getName(),
				t1.isAlive() ? "" : "not ",
				t1.getState());

		Thread t2 = new Thread(r);
		t2.setName("thd2");

		if (isDaemon)
			t2.setDaemon(true);

		System.out.printf("%s is %salive and in %s state%n",
				t2.getName(),
				t2.isAlive() ? "" : "not ",
				t2.getState());

		t1.start();
		t2.start();
	}
}