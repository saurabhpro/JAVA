package c_behavioral.k_visitor.visitor.visitor;

import c_behavioral.k_visitor.visitor.PartsOrder;
import c_behavioral.k_visitor.visitor.parts.Fender;
import c_behavioral.k_visitor.visitor.parts.Oil;
import c_behavioral.k_visitor.visitor.parts.Wheel;

public interface AtvPartVisitor {
	void visit(Wheel wheel);

	void visit(Fender fender);

	void visit(Oil oil);

	void visit(PartsOrder partsOrder);
}
