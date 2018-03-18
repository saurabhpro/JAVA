/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.medium.post;

interface ITestDrive {
	String MODEL_NAME = "Durant"; //implicit public + static + final

	void getCustomerId(); // implicit public + abstract
}

interface IMoreIsAlwaysGood {
	int MADE = 100;        // I can't be private!

	static void makeThis() {
		System.out.println("check it - I'm static - you can't override me like default, you can also make me private and you can also make methods with name same as me in inheriting interfaces and classes - cheers Mate!");
	}

	default void show() {
		System.out.println("I'm a default method in Interface and yes I'm not abstract but you can always override me in any inheriting Interface or implementing Class!\n Also I can't be private since I'm already 'default'");
	}

	private void youCantSeeMe() {
		System.out.println("If you don't belong in this - you can't see me");
	}


	void guessWhat();
}