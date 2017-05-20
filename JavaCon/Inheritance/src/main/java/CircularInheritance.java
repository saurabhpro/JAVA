/**
 * Created by Saurabh on 8/14/2015.
 */
public class CircularInheritance {
	public static void main(String[] args) {
		B b = new B();

	}
}

//class B extends  A{}

/**
 * class A extends B{}
 * class B extends C{}
 * class C extends A{}  // this will give you compile time error. [in c++. C# too]
 * <p>
 * The super class must be initialized first then only it can be extended.
 * Cycle creates infinite loop
 */

class B {
	B() {
		System.out.println("B");

	}
}

class A extends B {
	A() {
		System.out.println("A");
	}
}


