package concurrency.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Athlete {
	int stroke = 0;

	public static void main(String... laps) {
		ExecutorService s = Executors.newFixedThreadPool(10);
		Athlete a = new Athlete();
		for (int i = 0; i < 1000; i++) {
			s.execute(() -> a.swimming());
		}
		s.shutdown();
		System.out.print(a.stroke);
	}

	public synchronized void swimming() {
		stroke++;
	}
}