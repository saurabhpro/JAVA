package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Riddle {
	public static void main(String... ununused) {
		final Riddle r1 = new Riddle();
		final Riddle r2 = new Riddle();
		ExecutorService s = Executors.newFixedThreadPool(2);

		s.submit(() -> r1.getQuestion(r2));
		s.execute(() -> r2.getAnswer(r1));

		s.shutdown();
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (Exception ignored) {
		}
	}

	public String getQuestion(Riddle r) {
		synchronized (this) {
			sleep();
			if (r != null) r.getAnswer(null);
			return "How many programmers does it take "
					+ "to change a light bulb?";
		}
	}

	public synchronized String getAnswer(Riddle r) {
		sleep();
		if (r != null) r.getAnswer(null);
		return "None, that's a hardware problem";
	}
}