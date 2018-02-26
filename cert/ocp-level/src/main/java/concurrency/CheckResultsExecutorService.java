package concurrency;

import java.util.concurrent.*;

public class CheckResultsExecutorService {
	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		ExecutorService service = null;

		try {
			service = Executors.newSingleThreadExecutor();

			Future<?> result = service.submit(() -> {
				for (int i = 0; i < 500; i++) CheckResultsExecutorService.counter++;
			});

			result.get(10, TimeUnit.SECONDS);
			System.out.println("Reached! " + result.isDone());

		} catch (TimeoutException e) {
			System.out.println("Not reached in time");

		} finally {
			if (service != null) service.shutdown();
		}

		if (service != null) {
			service.awaitTermination(1, TimeUnit.MINUTES);

			// Check whether all tasks are finished
			if (service.isTerminated())
				System.out.println("All tasks finished");
			else
				System.out.println("At least one task is still running");
		}
	}
}