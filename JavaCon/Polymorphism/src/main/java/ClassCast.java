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
		A ob1 = new C();
		/*
		 In bytecode        C ob1 = new C();
		 but this doesnt happen till runtime
		 */

		B ob2 = (B) ob1;
		//ob1 is of type A at compile time, so casting needed,
		// if C hota to explicitly karne ka jaroorat nhi parta

		/*(B) new C()       upcasting??? NOT Required!
		   at this point we have a reference of type C, when we want to cast it to B,
		   compiler check first if its possible, since C extends B, YES, possible!
		   so we perform explicit type promotion with (B)
		 */

		System.out.print("ob2.f() = ");
		/*
		  ob2 has reference of type B now.. ob2 has methods of itself which it'll run like show2()
		  and ob2 is transitively holding reference of C, so the overridden method of child class will run
		 */
		ob2.f();        //runs the overriden method in the reference it holds
		ob2.show2();

		/****************************/
		//CASE 2: Explicit Class Cast Exception

		/*
		  We know D extends A and B extends A, so if we do this
		 */
		A ob4 = new D();
		B ob5 = (B) ob4;
		/*
		  ob4 is reference type of A at compile time, so this should've worked right?
		 */
		ob5.show2();        // indeed works [no compile time error] BUT runtime exception

		/*
		  TWIST!!!
		  this throws java.lang.ClassCastException: D cannot be cast to B
		  where the fuck did D come from ?
		  think again at runtime the resolve is made and ob4 becomes of A upcasting D, but its still D's reference
		  and since B doesnt have relation with D... exception is thrown
		 */

		A ob7 = new A();
		B ob8 = (B) ob7;
		/*
		  ob7 is reference type of A, so this should've worked right?
		  well, not really as A is parent and B is child
		 */
		ob8.show2();
	}

}
