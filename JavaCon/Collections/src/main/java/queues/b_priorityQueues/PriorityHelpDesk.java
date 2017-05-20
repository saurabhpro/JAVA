package queues.b_priorityQueues;


import queues.model.Category;
import queues.model.Customer;
import queues.model.Enquiry;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityHelpDesk {

	private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
		public int compare(final Enquiry o1, final Enquiry o2) {
			return o1.getCategory().compareTo(o2.getCategory());
		}
	};

	private Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

	public static void main(String[] args) {
		PriorityHelpDesk helpDesk = new PriorityHelpDesk();

		helpDesk.enquire(Customer.JACK, Category.PHONE);
		helpDesk.enquire(Customer.JILL, Category.PRINTER);
		helpDesk.enquire(Customer.MARY, Category.COMPUTER);

		helpDesk.processAllEnquires();
	}

	private void enquire(final Customer customer, final Category type) {
		enquiries.offer(new Enquiry(customer, type));
	}

	private void processAllEnquires() {
		Enquiry enquiry;
		while ((enquiry = enquiries.poll()) != null) {
			enquiry.getCustomer().reply("Have you tried turning it off and on again?");
		}
	}
}
