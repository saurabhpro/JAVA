package concurrency.singleExecutor;

import java.util.concurrent.*;

public class ExecutorsIn {

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

		Runnable task1 = () -> System.out.println("Hello Zoo");
		Callable<String> task2 = () -> "Monkey";

		Future<?> result1 = service.schedule(task1, 10, TimeUnit.SECONDS);
		ScheduledFuture<?> result2 = service.schedule(task2, 8, TimeUnit.SECONDS);

		try {
			System.out.println(result1.get());
			System.out.println(result2.get(100, TimeUnit.MILLISECONDS));
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}

		System.out.println(result2.getDelay(TimeUnit.SECONDS));


		/*
		 * scheduleAtFixedDelay() and scheduleAtFixedRate(), DON'T take a Callable object as an input parameter.
		 * Since these tasks are scheduled to run infinitely, as long as the ScheduledExecutorService is still alive,
		 * they would generate an endless series of Future objects.
		 */

		// creates a new task and submits it to the executor every period,
		// regardless of whether or not the previous task finished.
		// eg. checking the health of the animals once a day
		// “The scheduleAtFixedRate() method creates a new task for the associated action at a set time interval,
		// even if previous tasks for the same action are still active.”
		ScheduledFuture<?> atFixedRate = service.scheduleAtFixedRate(task1, 5, 1, TimeUnit.MINUTES);

		// creates a new task after the previous task has  finished.
		// eg.  restocks the salad bar throughout the day.
		ScheduledFuture<?> withFixedDelay = service.scheduleWithFixedDelay(task1, 0, 2, TimeUnit.MINUTES);


		service = Executors.newScheduledThreadPool(10);
		service.scheduleAtFixedRate(task1, 3, 1, TimeUnit.MINUTES);


		service.awaitTermination(10, TimeUnit.SECONDS);
	}
}
