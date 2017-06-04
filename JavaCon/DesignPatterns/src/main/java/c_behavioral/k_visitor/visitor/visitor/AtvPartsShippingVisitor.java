package c_behavioral.k_visitor.visitor.visitor;

import c_behavioral.k_visitor.visitor.PartsOrder;
import c_behavioral.k_visitor.visitor.parts.AtvPart;
import c_behavioral.k_visitor.visitor.parts.Fender;
import c_behavioral.k_visitor.visitor.parts.Oil;
import c_behavioral.k_visitor.visitor.parts.Wheel;

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
