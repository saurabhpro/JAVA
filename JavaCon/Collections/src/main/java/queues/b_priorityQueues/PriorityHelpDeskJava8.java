/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
