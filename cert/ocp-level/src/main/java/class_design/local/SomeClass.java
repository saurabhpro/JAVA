package class_design.local;

interface SomeLocalInnerClass2 {

	// since java 8 allows methods - this is again possible (both default and static methods are good
	default void someFunction() {

		// all rules of variable's apply - so no access modifiers etc - final and abstract is allowed

		abstract class Local {
			// It is not available outside of someFunction, not even to the members of the SomeClass.
			// Since you cannot declare a local variable static, you also cannot declare a local class static.

			// also, cannot have static things here as well
			//static int anInt = 8;
		}

		final class Local2 {
		}

		// interface are inherently static so - obv. NOt Allowed
		// interface ok { }
	}
}

class SomeLocalInnerClass {

	void someFunction() {

		// all rules of variable's apply - so no access modifiers etc - final and abstract is allowed

		abstract class Local {
			// It is not available outside of someFunction, not even to the members of the SomeClass.
			// Since you cannot declare a local variable static, you also cannot declare a local class static.

			// also, cannot have static things here as well
			// static int anInt = 8;
		}

		final class Local2 {
		}

		// interface are inherently static so - obv. NOt Allowed
		// interface ok { }
	}
}