package from.pluralsight.runnable;

public class FirstRunnable {

	public static void main(String[] args) {

		Runnable runnable = () -> {
			System.out.println("I am running in " + Thread.currentThread().getName());
		};

		//plug in the reference of the runnable in Thread constructor
		Thread t = new Thread(runnable);
		t.setName("My thread");

		t.start();
		// t.run(); // NO NO NO!!!
	}
}
