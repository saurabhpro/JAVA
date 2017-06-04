package c_behavioral.k_visitor.visitor;


import c_behavioral.k_visitor.visitor.parts.Fender;
import c_behavioral.k_visitor.visitor.parts.Oil;
import c_behavioral.k_visitor.visitor.parts.Wheel;
import c_behavioral.k_visitor.visitor.visitor.AtvPartsDisplayVisitor;
import c_behavioral.k_visitor.visitor.visitor.AtvPartsShippingVisitor;

public class VisitorDemo {

	public static void main(String[] args) {
		PartsOrder order = new PartsOrder();
		order.addPart(new Wheel());
		order.addPart(new Fender());
		order.addPart(new Oil());

		order.accept(new AtvPartsShippingVisitor());

		order.accept(new AtvPartsDisplayVisitor());
	}
}
