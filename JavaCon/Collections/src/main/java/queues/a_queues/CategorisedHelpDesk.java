/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package queues.a_queues;

import queues.model.Category;
import queues.model.Customer;
import queues.model.Enquiry;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

import static queues.model.Category.PRINTER;

public class CategorisedHelpDesk {
	private final Queue<Enquiry> enquiries = new ArrayDeque<>();

	public static void main(String[] args) {
		CategorisedHelpDesk helpDesk = new CategorisedHelpDesk();

		helpDesk.enquire(Customer.JACK, Category.PHONE);
		helpDesk.enquire(Customer.JILL, PRINTER);

		helpDesk.processPrinterEnquiry();
		helpDesk.processGeneralEnquiry();
		helpDesk.processPrinterEnquiry();
	}

	private boolean enquire(final Customer customer, final Category type) {
		return enquiries.offer(new Enquiry(customer, type));
	}

	private void processPrinterEnquiry() {
		processEnquiry(
				enq -> enq.getCategory() == PRINTER,
				"Is it out of paper?");
	}

	private void processGeneralEnquiry() {
		processEnquiry(
				enq -> enq.getCategory() != PRINTER,
				"Have you tried turning it off and on again?");
	}

	private void processEnquiry(final Predicate<Enquiry> predicate, final String message) {
		final Enquiry enquiry = enquiries.peek();
		if (enquiry != null && predicate.test(enquiry)) {
			enquiries.remove();

			enquiry.getCustomer().reply(message);
		} else {
			System.out.println("No work to do, let's have some ccd!");
		}
	}
}
