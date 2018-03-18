/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Threads;

/**
 * Created by Saurabh on 9/16/2015.
 */

class Thread1 implements Runnable {
	public void run() {
		System.out.println("Inside saurabh.Threads.Thread1");
	}
}

public class AnonymousThreadExecution {

	public static void main(String[] args) {
		Thread1 t = new Thread1() {
			@Override
			public void run() {
				System.out.println("Inside Runnable");
			}
		};

		t.run();
	}

}
