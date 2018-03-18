/*
 * Copyright (c) 2018 Saurabh Kumar
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