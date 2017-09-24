package Ch15_Threads_and_Locks.Q15_03_Dining_Philosophers.QuestionA;

import CtCILibrary.AssortedMethods;

class Philosopher extends Thread {
	private final int maxPause = 100;
	private final int bites = 10;

	private final Chopstick left;
	private final Chopstick right;
	private final int index;

	public Philosopher(int i, Chopstick left, Chopstick right) {
		index = i;
		this.left = left;
		this.right = right;
	}

	private void eat() {
		System.out.println("Philosopher " + index + ": start eating");
		if (pickUp()) {
			chew();
			putDown();
			System.out.println("Philosopher " + index + ": done eating");
		} else {
			System.out.println("Philosopher " + index + ": gave up on eating");
		}
	}

	private boolean pickUp() {
		pause();
		if (!left.pickUp()) {
			return false;
		}
		pause();
		if (!right.pickUp()) {
			left.putDown();
			return false;
		}
		pause();
		return true;
	}

	private void chew() {
		System.out.println("Philosopher " + index + ": eating");
		pause();
	}

	private void pause() {
		try {
			int pause = AssortedMethods.randomIntInRange(0, maxPause);
			Thread.sleep(pause);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void putDown() {
		right.putDown();
		left.putDown();
	}

	public void run() {
		for (int i = 0; i < bites; i++) {
			eat();
		}
	}
}
