/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.medium.post;

interface IS1 {
	static void show() {
		System.out.println("Im in II1");
	}
}

interface IS2 {
	static void show() {
		System.out.println("Im in II3");
	}
}

class ShouldIShowYouEveryThing2 implements IS1, IS2 {
//	static void show(){
//	}       // allowed too


	public static void main(String[] args) {

		IS1 in1 = new ShouldIShowYouEveryThing2();
		IS1.show();

		IS2 in2 = new ShouldIShowYouEveryThing2();
		IS2.show();
	}

	void show() {
		//no problem since we are not overriding anything, the IS2.show() is static, if its default - weaker privilege problem arises - since we are overriding then
	}
}