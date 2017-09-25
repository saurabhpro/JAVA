/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.c_behavioral.k_visitor.visitor.visitor;

import pluralsight.c_behavioral.k_visitor.visitor.PartsOrder;
import pluralsight.c_behavioral.k_visitor.visitor.parts.AtvPart;
import pluralsight.c_behavioral.k_visitor.visitor.parts.Fender;
import pluralsight.c_behavioral.k_visitor.visitor.parts.Oil;
import pluralsight.c_behavioral.k_visitor.visitor.parts.Wheel;

import java.util.List;

public class AtvPartsShippingVisitor implements AtvPartVisitor {

	private double shippingAmount = 0;

	@Override
	public void visit(Wheel wheel) {
		System.out.println("Wheels are bulky and expensive to ship.");
		shippingAmount += 15;
	}

	@Override
	public void visit(Fender fender) {
		System.out.println("Fenders are light and cheap to ship.");
		shippingAmount += 3;
	}

	@Override
	public void visit(Oil oil) {
		System.out.println("Oil is hazardous and has a fee to ship.");
		shippingAmount += 9;
	}

	@Override
	public void visit(PartsOrder order) {
		System.out.println("If they bought more than 3 things we will give them a discount on shipping.");
		List<AtvPart> parts = order.getParts();
		if (parts.size() > 3) {
			shippingAmount -= 5;
		}
		System.out.println("Shipping amount is: " + shippingAmount);
	}
}
