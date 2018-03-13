package concurrency.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * “When a CyclicBarrier goes over its limit, the barrier count is reset to zero.
 * The application defines a CyclicBarrier with a barrier limit of 5 threads.
 * The application then submits 12 tasks to a cached executor service.
 * <p>
 * In this scenario, a cached thread executor will use between 5 and 12 threads,
 * reusing existing threads as they become available.
 * In this manner, there is no worry about running out of available threads.
 * The barrier will then trigger twice, printing five 1s for each of the sets of threads, for a total of ten 1s. ”
 */
public class Boat {
	public static void main(String[] oars) {
		ExecutorService service = null;
		try {
			service = Executors.newCachedThreadPool();
			new Boat().row(service);
		} finally {
			service.shutdown();
		}
	}

	private void waitTillFinished(CyclicBarrier c) {
		try {
			c.await();
			System.out.print("1");  // 5 + 5 and then wait for 2....
		} catch (Exception e) {
		}
	}

	public void row(ExecutorService service) {
		final CyclicBarrier cb = new CyclicBarrier(5);
		IntStream.iterate(1, i -> i + 1)
				.limit(12)
				.forEach(i -> service.submit(() -> waitTillFinished(cb)));
	}
}