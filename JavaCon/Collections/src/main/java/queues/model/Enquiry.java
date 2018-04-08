/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package queues.model;

public class Enquiry {
	private final Customer customer;
	private final Category category;

	public Enquiry(final Customer customer, final Category category) {
		this.customer = customer;
		this.category = category;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Category getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Enquiry{" +
				"customer='" + customer + '\'' +
				", category=" + category +
				'}';
	}
}
