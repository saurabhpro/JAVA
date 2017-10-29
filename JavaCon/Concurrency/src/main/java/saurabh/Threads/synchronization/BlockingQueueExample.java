/*
 * Copyright 2017 Saurabh Kumar 29/10/17 9:42 AM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package saurabh.Threads.synchronization;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Operations Throws Exception	Special Value	Blocks	Times Out
 * Insert	    add(o)          offer(o)	    put(o)	offer(o, timeout, timeunit)
 * Remove	    remove(o)	    poll()	        take()	poll(timeout, timeunit)
 * Examine	    element()	    peek()
 * <p>
 * It is not possible to insert null into a BlockingQueue. If you try to insert null, the BlockingQueue will throw a NullPointerException.
 */
public class BlockingQueueExample {

	public static void main(String[] args) throws Exception {

		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1024);

		// The Producer inserts strings into a shared BlockingQueue, and the Consumer takes them out.
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}
}

class Producer implements Runnable {

	protected BlockingQueue<Integer> queue = null;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void produce() throws InterruptedException {
		Random random = new Random();

		while (true) {
			queue.put(random.nextInt(100));
		}
	}
}

class Consumer implements Runnable {

	protected BlockingQueue<Integer> queue = null;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {
		Random random = new Random();

		Thread.sleep(100);

		if (random.nextInt(10) == 0) {
			Integer value = queue.take();

			System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
		}
	}
}