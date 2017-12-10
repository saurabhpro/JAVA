package class_design.interfaces;

interface BaseInterface {
	default public void foo() {
		System.out.println("BaseInterface's foo");
	}

	default strictfp void show() {
	}

	enum o {}
	//strictfp void show(){} // not allowed since abstract
}

class BaseClass {
	public void foo() {
		System.out.println("BaseClass's foo");
	}
}

// Scenario 2: If a base class and a base interface define methods with the same signature,
// the method definition in the class is used and the interface definition is ignored

// By resolving the conflict by “class wins” rule, the method from the base class will always be selected.
// hence no impact on old classes and default methods in interface
public class Diamond extends BaseClass implements BaseInterface {
	public static void main(String[] args) {
		new Diamond().foo();
	}

	@Override
	strictfp public void show() {
		// how :P
	}
}