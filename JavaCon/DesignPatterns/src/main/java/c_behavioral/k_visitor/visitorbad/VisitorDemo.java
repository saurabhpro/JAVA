package c_behavioral.k_visitor.visitorbad;

import c_behavioral.k_visitor.visitorbad.parts.Fender;
import c_behavioral.k_visitor.visitorbad.parts.Oil;
import c_behavioral.k_visitor.visitorbad.parts.Wheel;

public class VisitorDemo {

	public static void main(String[] args) {
		PartsOrder order = new PartsOrder();
		order.addPart(new Wheel());
		order.addPart(new Fender());
		order.addPart(new Oil());

		double shippingCost = order.calculateShipping();

		System.out.println(shippingCost);
	}
}
