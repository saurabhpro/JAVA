/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Threads.creation.basic;

/**
 * Created by Saurabh on 10/29/2017.
 */

public class AnonymousRunnable {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside Run");
			}
		}
		);

		t.start();

		Thread t2 = new Thread(() -> System.out.println("Inside Run"));

		t2.start();
	}
}
