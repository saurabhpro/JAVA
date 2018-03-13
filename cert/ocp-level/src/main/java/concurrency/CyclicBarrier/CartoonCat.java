package concurrency.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CartoonCat {
	public static void main(String... strings) {
		new CartoonCat().march(new CyclicBarrier(4, () -> System.out.println("Ready")));
	}

	private void await(CyclicBarrier c) {
		try {
			c.await();
		} catch (Exception e) {
		}
	}

	public void march(CyclicBarrier c) {
		ExecutorService s = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 12; i++)
			s.execute(() -> await(c));
		s.shutdown();
	}
}