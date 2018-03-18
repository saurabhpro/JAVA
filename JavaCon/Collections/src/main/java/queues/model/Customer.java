/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package queues.model;

public class Customer {
	public static final Customer JACK = new Customer("Jack");
	public static final Customer JILL = new Customer("Jill");
	public static final Customer MARY = new Customer("Mary");

	private final String name;

	private Customer(final String name) {
		this.name = name;
	}

	public void reply(final String message) {
		System.out.printf("%s: %s\n", name, message);
	}
}
