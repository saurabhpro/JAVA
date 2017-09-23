/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package c_behavioral.b_command;

public class CommandEverydayDemo {

	public static void main(String[] args) {
		Task task1 = new Task(10, 12); //encapsulates request
		Task task2 = new Task(11, 13);

		Thread thread1 = new Thread(task1);
		thread1.start(); //invoker

		Thread thread2 = new Thread(task2);
		thread2.start();
	}
}

class Task implements Runnable {

	private final int num1;
	private final int num2;

	Task(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public void run() { //execute method
		System.out.println(num1 * num2); //receiver
	}
}
