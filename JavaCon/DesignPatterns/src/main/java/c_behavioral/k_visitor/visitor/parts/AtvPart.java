package c_behavioral.k_visitor.visitor.parts;

import c_behavioral.k_visitor.visitor.visitor.AtvPartVisitor;

public interface AtvPart {
	void accept(AtvPartVisitor visitor);
}
