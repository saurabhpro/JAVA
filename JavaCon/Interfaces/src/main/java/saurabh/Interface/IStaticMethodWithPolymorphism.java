/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package saurabh.Interface;

interface IStaticMethodWithPolymorphism {
	int TEST = 0;

	static void show() {
		System.out.println("Inside IStatic Parent Show");
		System.out.println(TEST);
	}
}

interface IDefaultMethod extends IStaticMethodWithPolymorphism {
	int TEST = 0;

	default void show() {
		System.out.println("Inside IDefault Child Show");
		System.out.println(this.TEST);
		System.out.println(IDefaultMethod.TEST);
	}
}

interface IStaticMethodTryingToOverrideError extends IDefaultMethod {
	int TEST = 0;

//	static void show(){
//		System.out.println("Inside IDefault Static Child Show");
//		System.out.println(this.TEST);
//		System.out.println(IDefaultMethod.TEST);
//	}

	@Override
	default void show() {
		System.out.println("Inside IDefault Child2 Show");
		System.out.println(this.TEST);
		System.out.println(IDefaultMethod.TEST);
	}
}

class Tester implements IDefaultMethod {
	/**
	 * Only override it with public access specifier
	 * - static method with same name is not allowed
	 * -
	 */
	@Override
	public void show() {
		System.out.println("Overriding default method in implementing class");
	}
}

class PolymorphicInheritanceMethodWorked implements IStaticMethodWithPolymorphism {
	static void show() {
		IStaticMethodWithPolymorphism.show();
	}
	// or you can create a same named non-static method -> you wont have any problem

	public static void main(String[] args) {
		IDefaultMethod test = new Tester();
		test.show();


		// IDefaultMethod iDefaultMethod = new  IStaticMethodTryingToOverrideError();
		// Not possible as interfaces are abstract
	}
}


// so it works as said interfaces having static method create no problem whatsover, even mixing default method is fine in sub classes