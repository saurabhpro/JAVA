package saurabh.Interface.Java8;

/**
 * Created by Saurabh on 10/22/2015.
 */

interface A {
	double PI = 3.14;

	static int make() {
		System.out.println("Inside A");
		System.out.println(A.class.getName() + " " + PI + " " + 47);
		return 47;
	}

	int show();
}

interface B extends A {
	static int make() {
		System.out.println("\nInside B");
		System.out.println(B.class.getName() + " " + A.make() + " " + 48);    //using function of interface A with same name
		return 48;
	}

	// void show();      error!!!
	int show();
}

/**
 * when we implement two interfaces and the interfaces have same method names you override the first interfaces method
 * signature implements A, B { //override the show method of A}
 * <p>
 * but if the return types of A, B show() are not same , program wont compile
 */
public class InterfaceStaticMethod implements A, B {
	public static void main(String[] args) {
		InterfaceStaticMethod staticMethod = new InterfaceStaticMethod();
		staticMethod.make();
		staticMethod.show();
	}

	@Override
	public int show() {
		return 0;
	}

	//classes own make function
	int make() {
		A.make(); //no problem as make is class level function, wont clash with any other classes make
		B.make();
		return 49;
	}
}
