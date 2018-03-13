package concurrency.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fun extends RecursiveTask<Integer> {
	final int value;

	public Fun(int value) {
		this.value = value;
	}

	public static void main(String... data) {
		ForkJoinPool pool = new ForkJoinPool();
		try {
			System.out.print(pool.invoke(new Fun(10)));
		} finally {
			pool.shutdown();
		}
	}

	@Override
	protected Integer compute() { // w1
		if (value < 1) {
			return 1;
		}
		final Fun f1 = new Fun(value - 1);
		final Fun f2 = new Fun(value - 2);
		return f1.compute() * f2.compute();
	}
}