package concurrency.stream;

import java.util.ArrayList;
import java.util.List;

public class WhaleDataCalculator {

	public static void main(String[] args) {
		WhaleDataCalculator calculator = new WhaleDataCalculator();

		// Define the data
		List<Integer> data = new ArrayList<>();
		for (int i = 0; i < 4000; i++) data.add(i);

		// Process the data
		long start = System.currentTimeMillis();
		calculator.processAllData(data);
		double time = (System.currentTimeMillis() - start) / 1000.0;

		// Report results
		System.out.println("\nTasks completed in: " + time + " seconds");
	}

	private int processRecord(int input) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// Handle interrupted exception
		}
		return input + 1;
	}

	private void processAllData(List<Integer> data) {
		/*
		long count = data
				.stream()                       // Tasks completed in: 48.508 seconds
				.map(a -> processRecord(a))
				.count();
		*/

		long count = data
				.parallelStream()               // Tasks completed in: 11.874 seconds
				.map(a -> processRecord(a))
				.count();

		System.out.println(count);
	}
}