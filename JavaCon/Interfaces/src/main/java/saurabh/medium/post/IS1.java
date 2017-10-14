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