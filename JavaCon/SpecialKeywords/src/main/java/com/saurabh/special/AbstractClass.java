/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special;

public abstract class AbstractClass {

	private final int num;

	//can have a no-args constructor for inheritance purposes
	AbstractClass() {
		num = 5;
	}
}

class New {
	public static void main(String[] args) {
		//AbstractClass abstractClass = new AbstractClass();
		//System.out.println(abstractClass.num);
	}
}
