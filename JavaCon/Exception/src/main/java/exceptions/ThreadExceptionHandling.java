/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package exceptions;

public class ThreadExceptionHandling {
	public static void main(String[] args) {

		Thread t1 = new Thread(ThreadExceptionHandling::run);

		t1.setName("TestingExceptionHandler");

		//noinspection Convert2Lambda
		t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread thisThread, Throwable hasException) {
				System.out.println("Thread : " + thisThread.getName() + " has this problem: " + hasException.getMessage());
			}
		});

		t1.start();

	}

	private static void run() {
		System.out.println("this is " + Thread.currentThread().getName());
		throw new RuntimeException("My own exception - unchecked");
	}
}
