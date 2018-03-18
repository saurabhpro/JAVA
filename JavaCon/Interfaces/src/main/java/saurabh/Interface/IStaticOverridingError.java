/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Interface;

interface IStaticOverridingError {
	static void show() {
		System.out.println("Inside Parent Static Method");
	}
}

interface IStaticOverridingTest extends IStaticOverridingError {
	static void show() {
		System.out.println("Inside Child Static Method");
	}
}

interface IStaticOverridingTest2 extends IStaticOverridingError {
	static void show() {
		System.out.println("Inside Child2 Static Method");
	}
}

class StaticInterfaceMethodWorks implements IStaticOverridingTest2 {
	static void show() {
		// possible
	}

	public static void main(String[] args) {
		IStaticOverridingTest2.show();

		IStaticOverridingTest2 overloadingTest2 = new StaticInterfaceMethodWorks();
		// overloadingTest2.show(); since we can't do this - no problem like the polymorphic case
	}
}

