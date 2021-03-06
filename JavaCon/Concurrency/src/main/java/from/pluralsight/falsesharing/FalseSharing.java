/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package from.pluralsight.falsesharing;

import java.util.stream.IntStream;

public class FalseSharing {

	private final static long ITERATIONS = 50_000_000L;
	private static final int NUM_THREADS_MAX = 4;
	private static final VolatileLongPadded[] paddedLongs;
	private static final VolatileLongUnPadded[] unPaddedLongs;

	static {
		paddedLongs = new VolatileLongPadded[NUM_THREADS_MAX];
		IntStream.range(0, paddedLongs.length).forEach(i -> paddedLongs[i] = new VolatileLongPadded());

		unPaddedLongs = new VolatileLongUnPadded[NUM_THREADS_MAX];
		IntStream.range(0, unPaddedLongs.length).forEach(i -> unPaddedLongs[i] = new VolatileLongUnPadded());
	}

	public static void main(final String[] args) throws Exception {
		runBenchmark();
	}

	private static void runBenchmark() throws InterruptedException {

		long begin, end;

		for (int n = 1; n <= NUM_THREADS_MAX; n++) {

			Thread[] threads = new Thread[n];

			for (int j = 0; j < threads.length; j++) {
				threads[j] = new Thread(createPaddedRunnable(j));
			}

			begin = System.currentTimeMillis();
			for (Thread t : threads) {
				t.start();
			}
			for (Thread t : threads) {
				t.join();
			}
			end = System.currentTimeMillis();
			System.out.printf("   Padded # threads %d - T = %dms\n", n, end - begin);

			for (int j = 0; j < threads.length; j++) {
				threads[j] = new Thread(createUnpaddedRunnable(j));
			}

			begin = System.currentTimeMillis();
			for (Thread t : threads) {
				t.start();
			}
			for (Thread t : threads) {
				t.join();
			}
			end = System.currentTimeMillis();
			System.out.printf(" UnPadded # threads %d - T = %dms\n\n", n, end - begin);
		}
	}

	private static Runnable createUnpaddedRunnable(final int k) {
		return () -> {
			long i = ITERATIONS + 1;
			while (0 != --i) {
				unPaddedLongs[k].value = i;
			}
		};
	}

	private static Runnable createPaddedRunnable(final int k) {
		//noinspection UnnecessaryLocalVariable
		Runnable paddedTouch = () -> {
			long i = ITERATIONS + 1;
			while (0 != --i) {
				paddedLongs[k].value = i;
			}
		};
		return paddedTouch;
	}

	final static class VolatileLongPadded {
		public long q1, q2, q3, q4, q5, q6;
		volatile long value = 0L;
		public long q11, q12, q13, q14, q15, q16;

	}

	final static class VolatileLongUnPadded {
		volatile long value = 0L;
	}
}
