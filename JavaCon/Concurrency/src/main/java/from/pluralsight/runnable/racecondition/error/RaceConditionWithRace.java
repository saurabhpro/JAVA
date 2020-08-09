/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package from.pluralsight.runnable.racecondition.error;


class RaceConditionWithRace {

	public static void main(String[] args) throws InterruptedException {

		LongWrapperWithRaceProblem longWrapperWithRaceProblem = new LongWrapperWithRaceProblem(0L);

		Runnable r = () -> {
			for (int i = 0; i < 1_000; i++) {
				longWrapperWithRaceProblem.incrementValue();
			}
		};

		Thread[] threads = new Thread[1_000];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(r);
			threads[i].start();
		}

		for (Thread thread : threads) {
			thread.join();
		}

		System.out.println("Value = " + longWrapperWithRaceProblem.getValue());
	}
}
