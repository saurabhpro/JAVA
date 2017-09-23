/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package saurabh.Interface.Java8;

/**
 * Created by Saurabh on 10/22/2015. Imp Points : 1. default methods present a chance of diamond problem, but if we have
 * two interface A1, B1 having same default method make(), we can't implement A1, B1 both. [ambiguity prob] -compilation
 * error 2. to make A1, A2 work, we have to provide an @overriden make() in our own class implementing both A1, B1
 * <p>
 * 3. we cant make our own function with same name as default methods in interfaces and use private, we would be
 * decreasing the visibility... which isnt allowed
 * <p>
 * 4. in case where A1 and B1 extends A1 are the two interfaces, so technically having same name methods means that we
 * would be overriding the default method of A1 in B1. so no ambiguity can arise, one a base class method is overriden ,
 * its overriden version is always run() in owr class implementing A1, B1
 * <p>
 * 5. this problem is not present in case of static methods in interfaces, as they just relate to interface class so can
 * be directly called like A.make(), to call a default method we need to upcast the class implemting interfaces to the
 * parent interfaces A1 a1 = new XYZ();  a1.make();
 */


@SuppressWarnings("ALL")
interface A1 {
	double PI = 3.14;

	default int make() {
		System.out.println("Inside A1");
		System.out.println(A1.class.getName() + " " + PI + " " + 47);
		return 47;
	}

	int show();
}

@SuppressWarnings("ALL")
interface B1 {
	default int make() {
		System.out.println("\nInside B1");
		System.out.println(B1.class.getName() + " " + " " + 48);    //using function of interface A with same name
		return 48;
	}

	// void show();      error!!!
	int show();
}

/**
 * if the return types of A, B show() are not same , program wont compile
 */
public class InterfaceDefaultMethod implements A1, B1 {
	public static void main(String[] args) {
		A1 a1 = new InterfaceDefaultMethod();
		a1.make();
		a1.show();
	}

	@Override
	public int show() {
		return 0;
	}


	//classes own make function
	@Override
	public int make() {
		// new A1().make(); //no problem as make is class level function, wont clash with any other classes make,
		// just that in case of default we cant lower the visibility, as its separate for objects

		// B1.make();
		System.out.println("dd");
		return 49;
	}

	//overloaded methods are allowed
	@SuppressWarnings({"SameReturnValue", "unused"})
	private int make(int a) {
		return 9;
	}
}