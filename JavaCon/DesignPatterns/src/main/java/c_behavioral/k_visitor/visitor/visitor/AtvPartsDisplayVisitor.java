package c_behavioral.k_visitor.visitor.visitor;

import c_behavioral.k_visitor.visitor.PartsOrder;
import c_behavioral.k_visitor.visitor.parts.Fender;
import c_behavioral.k_visitor.visitor.parts.Oil;
import c_behavioral.k_visitor.visitor.parts.Wheel;

public class AtvPartsDisplayVisitor implements AtvPartVisitor {

	@Override
	public void visit(Wheel wheel) {
		System.out.println("We have a wheel.");
	}

	@Override
	public void visit(Fender fender) {
		System.out.println("We have a fender.");

	}

	@Override
	public void visit(Oil oil) {
		System.out.println("We have oil.");

	}

	@Override
	public void visit(PartsOrder partsOrder) {
		System.out.println("We have an order.");

	}

}
