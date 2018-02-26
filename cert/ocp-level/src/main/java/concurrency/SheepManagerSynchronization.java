package concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerSynchronization {
	private int sheepCount = 0;

	public static void main(String[] args) {
		ExecutorService service = null;

		try {
			service = Executors.newFixedThreadPool(12);
			SheepManagerSynchronization manager = new SheepManagerSynchronization();

			for (int i = 0; i < 10; i++)
				service.submit(manager::incrementAndReport);
			System.out.println();

		} finally {
			if (service != null) service.shutdown();
		}

		Map<String, Object> foodData = new ConcurrentHashMap<>();
		foodData.put("penguin", 1);
		foodData.put("flamingo", 2);
		System.out.println("\n" + foodData);

		//  the iterator created by keySet() is updated as soon as an object is removed from the Map.
		for (String key : foodData.keySet())
			foodData.remove(key);

		System.out.println(foodData);
	}

	/* This will still be unordered - though
	private AtomicInteger sheepCount = new AtomicInteger(0);

	private void incrementAndReport() {
		System.out.print(sheepCount.incrementAndGet() + " ");
	}
	*/

	private void incrementAndReport() {
		synchronized (this) {
			System.out.print((++sheepCount) + " ");
		}
	}
}