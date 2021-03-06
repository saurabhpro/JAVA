/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package from.pluralsight.runnable.racecondition.solution;

class LongWrapper {

	private final Object key = new Object();
	private long l;

	public LongWrapper(long l) {
		this.l = l;
	}

	public long getValue() {
		synchronized (key) {
			return l;
		}
	}

	public void incrementValue() {
		synchronized (key) {
			l = l + 1;
		}
	}
}
