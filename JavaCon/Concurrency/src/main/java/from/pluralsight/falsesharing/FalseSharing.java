/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
