/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.saurabh.overriding;

/**
 * Created by Saurabh on 9/2/2015.
 */

class Base {
}

class Child extends Base {
}

class NewBase {
	Base Show() {
		System.out.println("Inside NewBase");
		return new Child();     //upcasting on the fly
	}

	Number disp() {
		return null;
	}
}

/**
 * The return type of overriding method in derived class must be equal to or smaller than
 * the return type of parent method in Base class
 */
class NewChild extends NewBase {
	@Override
	Child Show() {
		System.out.println("Inside NewChild, Indeed Covarient types are allowed at return types");
		return new Child();
	}

	@Override
	Integer disp() {
		return 5;
	}

	/*
	  but we cant have covariant returns for simple types like int with Integer etc

	  java: disp() in NewChild cannot override disp() in NewBase
	 return type int is not compatible with java.lang.Number
	 */
}

public class CovariantOverriding {
	public static void main(String[] args) {
		NewBase newBase = new NewBase();

		Base base = newBase.Show();
	}

}

