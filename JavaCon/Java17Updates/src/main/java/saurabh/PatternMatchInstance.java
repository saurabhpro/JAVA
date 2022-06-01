package saurabh;

class A {
	int x = 9;
}

class B extends A {
	int x = 2;
}

public class PatternMatchInstance {
	public static void main(String[] args) {
		Object obj = new B();

		if (obj instanceof A str) {
			// can use str here which can't access B's value of x
			System.out.println(str.x == 9); // is true
		} else {
			// can't use str here
			System.out.println("Can't use str here");
		}
	}
}
