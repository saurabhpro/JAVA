/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package generics.reflection.a_class_literals;

class Logger {
	private final String value;

	public Logger(String value) {
		this.value = value;
	}

	void log() {
		System.out.println(value);
	}
}
