/*
 * Copyright (c) 2018 Saurabh Kumar
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