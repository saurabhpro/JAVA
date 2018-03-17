/*
 * Copyright 2017 Saurabh Kumar 5/11/17 11:31 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package apress;

public class ThreadClassFeatures {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread();
		System.out.println(t.getContextClassLoader());
		System.out.println(t.getId());
		System.out.println(t.getName());
		System.out.println(t.getPriority());
		System.out.println(t.getState());
		System.out.println(t.isAlive());
		System.out.println(t.isDaemon());
		System.out.println(t.isInterrupted());

		boolean isDaemon = args.length != 0;
		Runnable r = new Runnable() {
			@Override
			public void run() {
				Thread thd = Thread.currentThread();
//				while (true)
//					System.out.printf("%s is %salive and in %s " +
//									"state%n",
//							thd.getName(),
//							thd.isAlive() ? "" : "not ",
//							thd.getState());
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
		t2.start();


		Thread.sleep(1000);
		t.interrupt();

		main();
	}

	public static void main() {
		Runnable r = () -> {
			String name = Thread.currentThread().getName();
			int count = 0;
			while (!Thread.interrupted())
				System.out.println(name + ": " + count++);
		};
		Thread thdA = new Thread(r);
		Thread thdB = new Thread(r);
		thdA.start();
		thdB.start();
		while (true) {
			double n = Math.random();
			if (n >= 0.49999999 && n <= 0.50000001)
				break;
		}
		thdA.interrupt();
		thdB.interrupt();
	}
}
