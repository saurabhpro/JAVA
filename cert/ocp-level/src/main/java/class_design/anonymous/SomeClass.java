package class_design.anonymous;

class SomeClass {

	void someFunction() {

		new Object() {
			// An additional difference is that an anonymous inner class cannot have any explicit constructors.
			// A constructor is named after the name of the class, and since an anonymous class has no name,
			// it follows that you cannot define a constructor!
		};

	}
}