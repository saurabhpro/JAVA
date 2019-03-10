/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package udemy.safebreaker;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Use Case : showing the multhreaded demo
 */
public class MultiThreadedBankDemo {

	private static final Logger logger = Logger.getLogger(MultiThreadedBankDemo.class.toString());
	private static final int MAX_PASSWORD = 9999;

	public static void main(String[] args) {
		Random random = new Random();

		int pass = random.nextInt(MAX_PASSWORD);
		Vault vault = new Vault(pass);

		List<Thread> threadList = List.of(new AscendingHackerThread(vault),
				new DescendingHackerThread(vault),
				new PoliceThread());

		threadList.forEach(Thread::start);

		logger.info(String.valueOf(pass));
	}


	/**
	 * having a password which the below classes will try to guess
	 */
	public static class Vault {
		private final int password;
		private final int timer = new Random().nextInt(9);

		public Vault(int password) {
			this.password = password;
			logger.info("Timer mills: "+timer);
		}

		public boolean isCorrectPassword(int guess) {
			try {
				TimeUnit.MILLISECONDS.sleep(timer);
			} catch (InterruptedException ignored) {
			}

			return guess == this.password;
		}
	}

	public static abstract class HackerThread extends Thread {
		protected final Vault vault;

		public HackerThread(Vault vault) {
			this.vault = vault;
			this.setName(this.getClass().getSimpleName());  // user friendly name
			this.setPriority(Thread.MAX_PRIORITY);
		}

		@Override
		public synchronized void start() {
			System.out.println("Starting Thread: " + this.getName());
			super.start();
		}
	}

	/**
	 * simply starts counting from top to max_password
	 */
	public static class AscendingHackerThread extends HackerThread {

		public AscendingHackerThread(Vault vault) {
			super(vault);
		}

		@Override
		public void run() {
			for (int i = 0; i <= MAX_PASSWORD; i++) {
				if (vault.isCorrectPassword(i)) {
					System.out.println(this.getName() + " guessed the password " + i);

					System.exit(0);
				}
			}
		}
	}

	/**
	 * simply starts counting from max_password to 0
	 */
	public static class DescendingHackerThread extends HackerThread {

		public DescendingHackerThread(Vault vault) {
			super(vault);
		}

		@Override
		public void run() {
			for (int i = MAX_PASSWORD; i >= 0; i--) {
				if (vault.isCorrectPassword(i)) {
					System.out.println(this.getName() + " guessed the password " + i);

					System.exit(0);
				}
			}
		}
	}

	/**
	 * simply waits for 10 seconds and then say you caught the hackers
	 */
	public static class PoliceThread extends Thread {
		@Override
		public void run() {
			for (int i = 10; i > 0; i--) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException ignored) {
				}
				System.out.println("Timer countdown: " + i);
			}

			System.out.println("Game over for you hackers - you are busted!");

			System.exit(0);
		}
	}


}
