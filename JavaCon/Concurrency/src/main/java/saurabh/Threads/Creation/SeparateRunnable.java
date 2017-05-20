package saurabh.Threads.Creation;

/**
 * Created by Saurabh on 10/21/2015.
 */

class MyThread implements Runnable {
	@Override
	public void run() {
		System.out.println("Inside Run");
	}
}

public class SeparateRunnable {
	public static void main(String[] args) {
		Thread t = new Thread(new MyThread());
		t.start();
	}
}
