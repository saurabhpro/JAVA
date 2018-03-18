/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package apress;

public class ThreadClassFeatures {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread();
		System.out.println(t.getContextClassLoader());
		System.out.println(t.getId());
		System.out.println(t.getName());
		System.out.println(t.getPriority());
		System.out.println(t.getState());
		System.out.println(t.isAlive());
		System.out.println(t.isDaemon());
		System.out.println(t.isInterrupted());

		boolean isDaemon = args.length != 0;
		Runnable r = new Runnable() {
			@Override
			public void run() {
				Thread thd = Thread.currentThread();
//				while (true)
//					System.out.printf("%s is %salive and in %s " +
//									"state%n",
//							thd.getName(),
//							thd.isAlive() ? "" : "not ",
//							thd.getState());
			}
		};

		Thread t1 = new Thread(r, "thd1");
		if (isDaemon)
			t1.setDaemon(true);
		System.out.printf("%s is %salive and in %s state%n",
				t1.getName(),
				t1.isAlive() ? "" : "not ",
				t1.getState());
		Thread t2 = new Thread(r);
		t2.setName("thd2");
		if (isDaemon)
			t2.setDaemon(true);

		System.out.printf("%s is %salive and in %s state%n",
				t2.getName(),
				t2.isAlive() ? "" : "not ",
				t2.getState());
		t2.start();


		Thread.sleep(1000);
		t.interrupt();

		main();
	}

	public static void main() {
		Runnable r = () -> {
			String name = Thread.currentThread().getName();
			int count = 0;
			while (!Thread.interrupted())
				System.out.println(name + ": " + count++);
		};
		Thread thdA = new Thread(r);
		Thread thdB = new Thread(r);
		thdA.start();
		thdB.start();
		while (true) {
			double n = Math.random();
			if (n >= 0.49999999 && n <= 0.50000001)
				break;
		}
		thdA.interrupt();
		thdB.interrupt();
	}
}
