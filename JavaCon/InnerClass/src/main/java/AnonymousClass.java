/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

/*
 * Created by Saurabh on 9/24/2015.
 */

/**
 * we want to override one or more methods of the super class on the fly.
 * Remember, anonymous inner classes are inherited ones, and we always use a superclass reference variable
 * to refer to an anonymous subclass object.
 * <p>
 * Once the anonymous class instance has been implicitly cast into the named type it can't be cast back
 * because there is no name for the anonymous type. You can access the additional members of the
 * anonymous inner class through this within the class, in the expression immediate after the expression
 * and the type can be inferred and returned through a method call.
 */

abstract class A {
	abstract void show();
}

class C extends A {
	@Override
	void show() {
		System.out.println("Inside C");
	}
}

public class AnonymousClass {
	public static void main(String[] args) {
		/* A a = new A() {}; // making A abstract in anonymous is not possible*/
		A a = new A() {
			@Override
			void show() {
				System.out.println("Inside Derived class of A");
			}

			//useless as we wont be able to call it with reference a
			void disp() {
				System.out.println("Inside Display");
			}
		};

		a.show();
		//a.disp(); not possible to call like this

		/* to run methods specific to an anonymous class
		 * twist is that what fn returns matters and according to it this snippet is used*/
		new Object() {
			void fn() {
				System.err.println("fn");
			}
		}.fn();

		A b = new C();

		int x = 9;
		// x=0;       effective final violated
		/* constructor of an no-name class*/
		A c = new C() {
			/*this is a new class  not C's but derived from C's and trasitively it casts to A
			 *   since there is no name for this derived class, we cannot write conventional constructor
			 * Anonymous inner class cannot have a named constructor, only an instance initializer:
			 */


			//use INSTANCE BLOCK
			{
				System.out.println("Inside Instance make constructor" + x);  // Access final x
			}
		};
	}


}
