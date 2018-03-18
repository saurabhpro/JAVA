/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Threads.creation;

/**
 * Created by Saurabh on 10/21/2015.
 */
class ThreadInnerClasses {
	/**
	 * using simple inner class extending thread
	 */
	static class InnerNamedThread extends Thread {

		final Thread inner;
		private final int countDown = 5;

		InnerNamedThread() {
			inner = new InnerNamedThread();
			inner.start();
		}

		@Override
		public String toString() {
			return Thread.currentThread().getName() + " : " + countDown;
		}

		@Override
		public void run() {
			System.out.println("Inside Named Thread Class Declaration " + this);
		}
	}

	/**
	 * Using Anonymous Thread Class
	 */
	static class InnerNamelessThread {
		final Thread t;

		InnerNamelessThread() {
			/*
			 * inside anonymous thread class,
			 * we can't use lambda here since the target type is a class, but expected interface
			 */
			t = new Thread() {
				@Override
				public void run() {
					System.out.println("Inside Anonymous Inner Class Threads run() => " + this);
				}
			};

			t.start();
		}
	}

	/**
	 * using named runnable implementation
	 */
	static class InnerNamedRunnable implements Runnable {
		final Thread t;

		InnerNamedRunnable() {
			t = new Thread(this);
			t.start();
		}

		@Override
		public void run() {
			System.out.println("Inside Named Inner Class implementing Runnable " + this);
		}

		@Override
		public String toString() {
			return "InnerNamedRunnable{" + t.getName() + "," + t.getPriority() + '}';
		}
	}

	/**
	 * class a anonymous Runnable Implementation
	 */

	static class InnerNamelessRunnable {
		final Thread t;

		InnerNamelessRunnable() {
			t = new Thread(/*lambda runnable*/() -> System.out.println("Inside Anonymous Runnable's run() => " + this));

			t.start();
		}

		@Override
		public String toString() {
			return "InnerNamelessRunnable{" + t.getName() + "," + t.getPriority() + '}';
		}
	}



	/**
	 * running thread from separate method [local inner class thread]
	 */

	static class LocalInnerThread {
		Thread t;

		public void task() {
			t = new Thread() {
				@Override
				public void run() {
					System.out.println("Inside local inner run () " + this);
				}
			};

			t.start();
		}
	}
}


public class InnerThreadVariations {
	public static void main(String[] args) {
		//new ThreadInnerClasses.InnerNamedThread();
		new ThreadInnerClasses.InnerNamelessThread();
		new ThreadInnerClasses.InnerNamedRunnable();
		new ThreadInnerClasses.InnerNamelessRunnable();
		new ThreadInnerClasses.LocalInnerThread().task();

	}
}
