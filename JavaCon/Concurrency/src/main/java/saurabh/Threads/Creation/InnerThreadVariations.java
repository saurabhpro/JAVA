package saurabh.Threads.Creation;

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
		private int countDown = 5;

		InnerNamelessThread() {
			/*
			 * inside anonymous thread class
			 */
			t = new Thread() {
				@Override
				public void run() {
					System.out.println("Inside Anonymous Inner Class Threads Run " + this);
				}
			};

			t.start();
		}
	}

	/**
	 * class a anonymous Runnable Implementation
	 */

	static class InnerNamelessRunnable {
		final Thread t;

		InnerNamelessRunnable() {
			t = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("Inside Anonymous Runnable's Run " + this);
				}
			});

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
	}

	/**
	 * running thread from separate method [local inner class thread]
	 */

	static class LocalInnerThread {
		Thread t;

		public void task() {
			if (t == null)
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
		//  new ThreadInnerClasses.InnerNamedThread();
		new ThreadInnerClasses.InnerNamelessThread();
		new ThreadInnerClasses.InnerNamedRunnable();
		new ThreadInnerClasses.InnerNamelessRunnable();
		new ThreadInnerClasses.LocalInnerThread().task();

	}
}
