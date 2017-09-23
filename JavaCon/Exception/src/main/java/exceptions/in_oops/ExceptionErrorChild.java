/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package exceptions.in_oops;

/**
 * Created by Saurabh on 8/16/2015.
 */

class Parent extends Exception {
	Parent(String str) {
		super(str);     //passes to Exceptions constructor
	}

	Parent() {
		super();
	}

	@Override
	public String getMessage() {
		return "Detail Message: " + super.getMessage();
	}
}

class Child extends Parent {
	Child() {
		super();
	}

	Child(String str) throws Child {
		super(str);
		throw new Child(str);
		/* java supports two type of throw statement [all standard exceptions have these
		  if you have your own class, provide these
		  1. throw new child() //default constructor
		  2. throe new child("String Arguments"); //string argument which can be late printed
		  Exception class has these two constructors
		 */
	}
}

public class ExceptionErrorChild {
	public static void main(String[] args) throws Child {
		try {
			Parent c = new Child("Hi");
		} catch (Exception e) {
			System.out.println("exceptions.in_oops.Child caught: " + e.getMessage());
			//    e.printStackTrace(System.out);
		}
	}
}
