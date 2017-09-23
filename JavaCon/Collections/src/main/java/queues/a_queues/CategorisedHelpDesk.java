/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
