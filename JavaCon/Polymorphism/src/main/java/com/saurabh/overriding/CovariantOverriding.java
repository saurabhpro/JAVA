/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.overriding;

/**
 * Created by Saurabh on 9/2/2015.
 */

class Base {
}

class Child extends Base {
}

class NewBase {
	Base Show() {
		System.out.println("Inside NewBase");
		return new Child();     //upcasting on the fly
	}

	Number disp() {
		return null;
	}
}

/**
 * The return type of overriding method in derived class must be equal to or smaller than
 * the return type of parent method in Base class
 */
class NewChild extends NewBase {
	@Override
	Child Show() {
		System.out.println("Inside NewChild, Indeed Covarient types are allowed at return types");
		return new Child();
	}

	@Override
	Integer disp() {
		return 5;
	}

	/*
	  but we cant have covariant returns for simple types like int with Integer etc

	  java: disp() in NewChild cannot override disp() in NewBase
	 return type int is not compatible with java.lang.Number
	 */
}

public class CovariantOverriding {
	public static void main(String[] args) {
		NewBase newBase = new NewBase();

		Base base = newBase.Show();
	}

}

