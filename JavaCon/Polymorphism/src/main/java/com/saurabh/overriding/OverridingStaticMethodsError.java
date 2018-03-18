/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.overriding;

/**
 * Created by Saurabh on 9/1/2015.
 */

class StaticPrivateOverriding {
	static void show() {
		System.out.println("Inside Parent Static Method");
	}

	private void play() {
		System.out.println("Inside parent Private play()");
	}
}

class ChildStaticPrivateOverride extends StaticPrivateOverriding {
	/*  void show()
	       instance method show() in ChildStaticPrivateOverride
	       cannot override static method show() in StaticPrivateOverriding

	 Error:(11, 10) java: show() in ChildStaticPrivateOverride cannot override show() in StaticPrivateOverriding
	               overridden method is static */

	/**
	 * we can only re-define it using static modifier, this proves that static method cannot be overriden
	 */
	static void show() {
		System.out.println("Inside Overriden Child");
	}

	/**
	 * we have a play() in parent but it is private , so we can have a method names play()
	 * in child class but it wont be overriding anything
	 */
	void play() {
		System.out.println("Inside Child's own play() which isnt overriding super's play()");
	}
}

public class OverridingStaticMethodsError {
	public static void main(String[] args) {
		StaticPrivateOverriding sOb = new ChildStaticPrivateOverride();
		StaticPrivateOverriding.show(); //static show of father
	}

}
