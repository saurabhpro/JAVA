/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package from.pluralsight.runnable.racecondition.solution;


class RaceCondition {

	public static void main(String[] args) throws InterruptedException {

		LongWrapper longWrapper = new LongWrapper(0L);

		Runnable r = () -> {

			for (int i = 0; i < 1_000; i++) {
				longWrapper.incrementValue();
			}
		};

		Thread[] threads = new Thread[1_000];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(r);
			threads[i].start();
		}

		for (Thread thread : threads) {
			thread.join();
		}

		System.out.println("Value = " + longWrapper.getValue());
	}
}
