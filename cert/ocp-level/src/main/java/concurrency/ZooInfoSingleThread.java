package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * With a single-thread executor, results are guaranteed to be executed in the order
 * in which they are added to the executor service.
 */
public class ZooInfoSingleThread {
	public static void main(String[] args) {

		ExecutorService service = null;
		try {

			service = Executors.newSingleThreadExecutor();
			// if this single thread terminates due to a failure during execution prior to
			// shutdown, a new one will take its place if needed to execute subsequent tasks.

			// Unlike the otherwise equivalent newFixedThreadPool(1) the returned executor is
			// guaranteed not to be reconfigurable to use additional threads.

			System.out.println("begin");

			service.execute(() -> System.out.println("Printing zoo inventory"));
			service.execute(() -> {
				for (int i = 0; i < 3; i++) {
					String s = "Printing record: " + i;
					System.out.println(s);
				}
			});
			service.execute(() -> System.out.println("Printing zoo inventory"));

			System.out.println("end");

		} finally {

			if (service != null) service.shutdown();
		}
	}
}