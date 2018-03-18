/*
 * Copyright (c) 2018 Saurabh Kumar
 */

//: innerclasses/greenhouse_TIJ.controller/Event.java
// The common methods for any control event.
package greenhouse_TIJ.controller;

public abstract class Event {
	protected final long delayTime;
	private long eventTime;

	protected Event(long delayTime) {
		this.delayTime = delayTime;
		start();
	}

	public void start() { // Allows restarting
		eventTime = System.nanoTime() + delayTime;
	}

	public boolean ready() {
		return System.nanoTime() >= eventTime;
	}

	public abstract void action();
} ///:~
