package c_behavioral.k_visitor.visitor.parts;

import c_behavioral.k_visitor.visitor.visitor.AtvPartVisitor;

public class Oil implements AtvPart {
	@Override
	public void accept(AtvPartVisitor visitor) {
		visitor.visit(this);
	}
}
