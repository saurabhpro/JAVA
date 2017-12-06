package interface_with_main;

interface TY {
	class Test {
		public static void main(String[] args) {
			System.out.println("Name");
		}

		void see() {
			System.out.println("see");
		}
	}
}

public class Test {

	public static void main(String[] args) {
		TY.Test test = new TY.Test();
		TY.Test.main(null);
		test.see();
	}
	// class Test{} compile time error
	// It is a compile-time error if a class has the same simple name as any of its enclosing classes or interfaces.
}

