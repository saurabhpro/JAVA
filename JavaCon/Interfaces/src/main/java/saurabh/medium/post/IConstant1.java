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

public interface IConstant1 {
	String Hello = "Hi There";
}

interface IConstant2 extends IConstant1 {
	String Hello = "Hi There Numbr 2";
	// here it doesn't matter if we are extending IConstant1, static things does not override, but re-declared!
}

class Tester2 implements IConstant1 {
	public static void main(String[] args) {
		System.out.println(Tester2.Hello);      // surprised much - this works
		System.out.println(IConstant2.Hello);      // this will work as well
	}
}

class Tester implements IConstant1, IConstant2 {
	public static void main(String[] args) {

		//System.out.println(Tester.Hello);       // This is error
		/*
		Error:(24, 42) java: reference to Hello is ambiguous
	    both variable Hello in saurabh.medium.post.IConstant1 and variable Hello in saurabh.medium.post.IConstant2 match
		 */

		// but
		System.out.println(IConstant1.Hello);
		System.out.println(IConstant2.Hello);
		// is not

		/* OUTPUT
		Hi There
		Hi There Numbr 2
		 */
	}
}
