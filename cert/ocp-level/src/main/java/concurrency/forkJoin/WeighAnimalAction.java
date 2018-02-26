package concurrency.forkJoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class WeighAnimalAction extends RecursiveAction {
	private int start;
	private int end;
	private Double[] weights;

	private WeighAnimalAction(Double[] weights, int start, int end) {
		this.start = start;
		this.end = end;
		this.weights = weights;
	}

	public static void main(String[] args) {
		Double[] weights = new Double[10];

		ForkJoinTask<?> task = new WeighAnimalAction(weights, 0, weights.length);
		ForkJoinPool pool = new ForkJoinPool();

		// The key concept to take away from this example is that the process was started as a single task,
		// and it spawned additional concurrent tasks to split up the work after it had already started.
		pool.invoke(task);

		// Print results
		System.out.println();
		System.out.print("Weights: ");
		Arrays.stream(weights).forEach(d -> System.out.print(d.intValue() + " "));
	}

	/**
	 * to define the recursive method for execution
	 */
	@Override
	protected void compute() {
		if (end - start <= 3)
			for (int i = start; i < end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				System.out.println("Animal Weighed: " + i);
			}
		else {
			int middle = start + ((end - start) / 2);
			System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");

			invokeAll(new WeighAnimalAction(weights, start, middle),
					new WeighAnimalAction(weights, middle, end));
		}
	}
}
