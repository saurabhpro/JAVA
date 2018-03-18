/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package queues.a_queues;

import queues.model.Category;
import queues.model.Customer;
import queues.model.Enquiry;

import java.util.ArrayDeque;
import java.util.Queue;

public class HelpDesk {
	private final Queue<Enquiry> enquiries = new ArrayDeque<>();

	public static void main(String[] args) {
		HelpDesk helpDesk = new HelpDesk();

		helpDesk.enquire(Customer.JACK, Category.PHONE);
		helpDesk.enquire(Customer.JILL, Category.PRINTER);

		helpDesk.processAllEnquiries();
	}

	private void enquire(final Customer customer, final Category category) {
		enquiries.offer(new Enquiry(customer, category));
	}

	private void processAllEnquiries() {
		Enquiry enquiry;

		while ((enquiry = enquiries.poll()) != null) {
			enquiry.getCustomer().reply("Have you tried turning it off and on again?");
		}
	}
}
