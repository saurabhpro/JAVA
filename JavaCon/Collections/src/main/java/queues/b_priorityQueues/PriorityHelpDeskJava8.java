/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package queues.b_priorityQueues;

import queues.model.Category;
import queues.model.Customer;
import queues.model.Enquiry;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Comparator.comparing;

public class PriorityHelpDeskJava8 {

	// private static final Comparator<Enquiry> BY_CATEGORY = (o1, o2) -> o1.getCategory().compareTo(o2.getCategory());
	private static final Comparator<Enquiry> BY_CATEGORY = comparing(Enquiry::getCategory);

	private final Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

	public static void main(String[] args) {
		PriorityHelpDeskJava8 helpDesk = new PriorityHelpDeskJava8();

		helpDesk.enquire(Customer.JACK, Category.PHONE);
		helpDesk.enquire(Customer.JILL, Category.PRINTER);
		helpDesk.enquire(Customer.MARY, Category.COMPUTER);

		helpDesk.processAllEnquires();
	}

	private boolean enquire(final Customer customer, final Category type) {
		return enquiries.offer(new Enquiry(customer, type));
	}

	private void processAllEnquires() {
		Enquiry enquiry;
		while ((enquiry = enquiries.poll()) != null) {
			enquiry.getCustomer().reply("Have you tried turning it off and on again?");
		}
	}
}
