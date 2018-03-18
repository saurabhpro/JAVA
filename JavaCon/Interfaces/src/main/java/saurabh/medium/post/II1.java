/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.medium.post;

interface II1 {
	default void show() {
		System.out.println("Im in II1");
	}
}

interface II2 extends II1 {
	void show(); // allowed but not overriding default implementation,
	// if you implements II1, II2 you will have to give implementation for this show() - hence overriding default one
}

interface II3 {
	default void show() {
		System.out.println("Im in II3");
	}
}

//interface II4 extends II1 {
//	private void show(){
//		System.out.println("Im in II3");
//	}
//}

class ShouldIShowYouEveryThing1 implements II1, II2, II3 {

	public static void main(String[] args) {

		II1 in1 = new ShouldIShowYouEveryThing1();
		in1.show();

		II2 in2 = new ShouldIShowYouEveryThing1();
		in2.show();

		II3 in3 = new ShouldIShowYouEveryThing1();
		in3.show();
	}

	@Override
	public void show() {
		System.out.println("Which one of the three shows am I overriding?");
	}

}