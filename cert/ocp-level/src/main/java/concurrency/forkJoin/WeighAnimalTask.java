package concurrency.forkJoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class WeighAnimalTask extends RecursiveTask<Double> {
	private int start;
	private int end;
	private Double[] weights;

	private WeighAnimalTask(Double[] weights, int start, int end) {
		this.start = start;
		this.end = end;
		this.weights = weights;
	}

	public static void main(String[] args) {
		Double[] weights = new Double[10];

		ForkJoinTask<Double> task = new WeighAnimalTask(weights, 0, weights.length);
		ForkJoinPool pool = new ForkJoinPool();

		// The key concept to take away from this example is that the process was started as a single task,
		// and it spawned additional concurrent tasks to split up the work after it had already started.
		Double sum = pool.invoke(task);

		// Print results
		System.out.println();
		System.out.print("Weights Sum: " + sum);
	}

	protected Double compute() {
		if (end - start <= 3) {
			double sum = 0;
			for (int i = start; i < end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				System.out.println("Animal Weighed: " + i);
				sum += weights[i];
			}
			return sum;

		} else {
			int middle = start + ((end - start) / 2);
			System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");

			RecursiveTask<Double> otherTask = new WeighAnimalTask(weights, start, middle);
			otherTask.fork();

			return new WeighAnimalTask(weights, middle, end).compute() + otherTask.join();
			/*
			the invokeAll() method doesn’t return a value, we instead issue a fork() and join() command to retrieve
			the recursive data. The fork() method instructs the fork/join framework to complete the task in
			a separate thread, while the join() method causes the current thread to wait for the results.
			 */
		}
	}

}