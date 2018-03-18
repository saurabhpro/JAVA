/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh;

public abstract class AbstractOk {
	AbstractOk() {
		System.out.println("abstract");
	}
}


class B extends AbstractOk {
	B() {
		System.out.println("in B");

	}

	public static void main(String[] args) {
		new B();
	}
}