/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.medium.post;

interface I1 {
	void show();
}

interface I2 extends I1 {
	void show();
}

interface I3 extends I1 {
	void show();
}

class ShouldIShowYouEveryThing implements I1, I2, I3 {
	public static void main(String[] args) {
		I3 in3 = new ShouldIShowYouEveryThing();
		in3.show();

		I2 in2 = new ShouldIShowYouEveryThing();
		in2.show();

		I1 in1 = new ShouldIShowYouEveryThing();
		in1.show();
	}

	@Override
	public void show() {
		System.out.println("Which one of the three shows am I overriding?");
	}

}