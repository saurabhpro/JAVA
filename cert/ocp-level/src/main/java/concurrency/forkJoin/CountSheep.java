package concurrency.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class CountSheep extends RecursiveAction {
	static int[] sheep = new int[]{1, 2, 3, 4};
	final int start;
	final int end;
	int count = 0;

	public CountSheep(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public static void main(String[] night) {

		CountSheep action = new CountSheep(0, sheep.length);
		ForkJoinPool pool = new ForkJoinPool();

		pool.invoke(action);

		pool.shutdown();

		System.out.print(action.count);
	}

	public void compute() {
		if (end - start < 2) {
			count += sheep[start];
			System.out.println(count);
		} else {
			int middle = start + (end - start) / 2;
			System.out.println(start + " " + middle + " " + end);
			invokeAll(new CountSheep(start, middle),
					new CountSheep(middle, end));
		}
	}
}