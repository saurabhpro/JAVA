/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.access;

/**
 * In Java, protected members of a class “A” are accessible in other class “B” of same package,
 * even if B doesn’t inherit from A (they both have to be in the same package).
 */
class A {
	protected int x = 10, y = 20;
}

class B {
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.x + " " + a.y);    // HOW!!!
	}
}