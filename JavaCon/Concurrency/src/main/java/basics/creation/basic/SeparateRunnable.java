/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package basics.creation.basic;

/**
 * Created by Saurabh on 10/21/2015.
 */


public class SeparateRunnable {

	static class MyThread implements Runnable {
		@Override
		public void run() {
			System.out.println("Inside Run");
		}
	}

	public static void main(String[] args) {
		Thread t = new Thread(new MyThread());
		t.start();
	}
}
