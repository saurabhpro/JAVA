package Basics;

class A {
	private int i;

	A(int i) {
		this.i = i;
	}
}

public class InheritanceSuper extends A {
	public InheritanceSuper(int i) {
		super(i); // cant call super() since no no-arg constrcuctor in A
	}
}
