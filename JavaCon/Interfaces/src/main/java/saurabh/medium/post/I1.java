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