package Ch13_Java.Q13_01_Private_Constructor;

/**
 * Whats is the effect of keeping constructor private?
 */
public class Question {
	//No one outside this class can access it
	private Question() {
		System.out.println("Q");
	}

	public static void main(String[] args) {
		new B();
		new Question();
	}

	static class A {
		private A() {
			System.out.println("A");
		}
	}

	static class B extends A {
		B() {
			super();
			System.out.println("Inside Class B");
		}
	}
}
