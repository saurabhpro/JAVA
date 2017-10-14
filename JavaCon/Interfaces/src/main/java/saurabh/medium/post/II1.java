/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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