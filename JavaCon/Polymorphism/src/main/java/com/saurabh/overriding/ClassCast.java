/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.saurabh.overriding;

/**
 * Created by Saurabh on 9/20/2015.
 */

class A {
	void f() {
		System.out.println("A");
	}
}

class B extends A {
	@Override
	void f() {
		System.out.println("B");
	}

	void show2() {
		System.out.println("s2");
	}
}

class C extends B {
	@Override
	void f() {
		System.out.println("C");
	}

	void show() {
		System.out.println("s3");
	}
}

class D extends A {
	@Override
	void f() {
		System.out.println("D");
	}
}

public class ClassCast {
	public static void main(String[] args) {
		// A a = new C() ;
		SunderSushilCastingWithSelfPreservationMethods();

		// A = A, B = (B) A
		DownCastingABaseClass();        // Error

		// A = D & then trying B = A - compiles as B is related to A, but fails at runtime
		CastingBetweenTwoUnrealatedClass(); // Error

	}

	private static void SunderSushilCastingWithSelfPreservationMethods() {
		A objC = new C();
		// In bytecode  C objC = new C(); // but this doesnt happen till runtime

		B objB = (B) objC;    // from base class to Subclass, remember this is required on compile time -
		//objC is of type A at compile time, so casting needed, if C hota to explicitly karne ka jaroorat nhi parta

		/*(B) new C()       upcasting??? NOT Required!
		   at this point we have a reference of type C, when we want to cast it to B,
		   compiler check first if its possible, since C extends B, YES, possible!
		   so we perform explicit type promotion with (B)
		 */

		System.out.print("objB.f() = ");

		/*
		  objB has reference of type B now.. objB has methods of itself which it'll run like show2()
		  and objB is transitively holding reference of C, so the overridden method of child class will run
		 */
		objB.f();        //runs the overriden method in the reference it holds
		objB.show2();   // show2 of B Class
	}

	private static void CastingBetweenTwoUnrealatedClass() {
		//CASE 2: Explicit Class Cast Exception

		/*
		  We know D extends A and B extends A, so if we do this
		 */
		A ob4 = new D();

		B ob5 = (B) ob4;
		/*
		  ob4 is reference type of A at compile time, so this should've worked right?
		 */
		//ob5.show2();        // indeed works [no compile time error] BUT runtime exception

		/*
		  TWIST!!!
		  this throws java.lang.ClassCastException: D cannot be cast to B

		  where the fuck did D come from ?
		  think again at runtime the resolve is made and ob4 becomes of A upcasting D, but its still D's reference
		  and since B doesn't have relation with D... exception is thrown
		 */
	}

	private static void DownCastingABaseClass() {
		A ob7 = new A();
		B ob8 = (B) ob7;
		/*
		  ob7 is reference type of A, so this should've worked right?
		  well, not really as A is parent and B is child

		  This Doesn't work even if A & B has only 1 method f()
		 */
		ob8.show2();
	}

}


/*
Old decompiled code
 C objC = new C();
      B objB = (B)objC;
      System.out.print("objB.f() = ");
      objB.f();
      objB.show2();
      D ob4 = new D();
      B ob5 = (B)ob4;
      ob5.show2();
      A ob7 = new A();
      B ob8 = (B)ob7;
      ob8.show2();
 */