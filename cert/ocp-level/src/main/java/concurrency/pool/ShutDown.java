package concurrency.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ShutDown {
	public static void main(String[] memo) {
		new ShutDown().submitReports();
	}

	private void submitReports() {
		ExecutorService service = Executors.newCachedThreadPool();

		// since it doesn't return anything - its  Runnable and hence Future = null
		Future bosses = service.submit(() -> System.out.print("this "));
		service.shutdown();

		try {
			System.out.print(bosses.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
