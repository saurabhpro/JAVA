package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

// Class to demonstrate how mutating "normal" (i.e., thread unsafe) integers
// and mutating "atomic" (i.e., thread safe) integers are different:
// Mutating a shared Integer object without locks can result in a race condition;
// however, mutating a shared AtomicInteger will not result in a race conditiond.
class Counter2 {
	public static Integer integer = 0;
	public static AtomicInteger atomicInteger = new AtomicInteger(0);
}

public class AtomicVariableTest {
	public static void main(String[] args) throws InterruptedException {
		Thread incremeterThread[] = new Incrementer[1000];
		Thread decrementerThread[] = new Decrementer[1000];

		for (int i = 0; i < 1000; i++) {
			incremeterThread[i] = new Incrementer();
			decrementerThread[i] = new Decrementer();
			incremeterThread[i].start();
			decrementerThread[i].start();
		}

		for (int i = 0; i < 1000; i++) {
			incremeterThread[i].join();
			decrementerThread[i].join();
		}

		System.out.printf("Integer value = %d AtomicInteger value = %d ", Counter2.integer, Counter2.atomicInteger.get());
	}

	static class Incrementer extends Thread {
		public void run() {
			Counter2.integer++;
			Counter2.atomicInteger.incrementAndGet();
		}
	}

	static class Decrementer extends Thread {
		public void run() {
			Counter2.integer--;
			Counter2.atomicInteger.decrementAndGet();
		}
	}
}
