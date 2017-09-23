/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package from.pluralsight.waitnotify;

import java.util.stream.IntStream;

public class ProducerConsumer {

	private static final Object lock = new Object();

	private static int[] stockBuffer;
	private static int count;

	private static boolean isEmpty(int[] stockBuffer) {
		return count == 0;
	}

	private static boolean isFull(int[] buffer) {
		return count == buffer.length;
	}

	public static void main(String... strings) throws InterruptedException {

		stockBuffer = new int[10];
		count = 0;

		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		Runnable produceTask = () -> {
			IntStream.range(0, 50).forEach(i -> producer.produce());
			System.out.println("Done producing");
		};
		Runnable consumeTask = () -> {
			IntStream.range(0, 45).forEach(i -> consumer.consume());
			System.out.println("Done consuming");
		};

		Thread consumerThread = new Thread(consumeTask);
		Thread producerThread = new Thread(produceTask);

		consumerThread.start();
		producerThread.start();

		consumerThread.join();
		producerThread.join();

		System.out.println("Data in the stockBuffer: " + count);
	}

	static class Producer {

		void produce() {
			synchronized (lock) {
				if (isFull(stockBuffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				stockBuffer[count++] = 1;
				lock.notify();
			}
		}
	}

	static class Consumer {

		void consume() {
			synchronized (lock) {
				if (isEmpty(stockBuffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				stockBuffer[--count] = 0;
				lock.notify();
			}
		}
	}
}
