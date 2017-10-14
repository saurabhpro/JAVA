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
 * Created by Saurabh on 9/1/2015.
 */

class StaticPrivateOverriding {
	static void show() {
		System.out.println("Inside Parent Static Method");
	}

	private void play() {
		System.out.println("Inside parent Private play()");
	}
}

class ChildStaticPrivateOverride extends StaticPrivateOverriding {
	/*  void show()
	       instance method show() in ChildStaticPrivateOverride
	       cannot override static method show() in StaticPrivateOverriding

	 Error:(11, 10) java: show() in ChildStaticPrivateOverride cannot override show() in StaticPrivateOverriding
	               overridden method is static */

	/**
	 * we can only re-define it using static modifier, this proves that static method cannot be overriden
	 */
	static void show() {
		System.out.println("Inside Overriden Child");
	}

	/**
	 * we have a play() in parent but it is private , so we can have a method names play()
	 * in child class but it wont be overriding anything
	 */
	void play() {
		System.out.println("Inside Child's own play() which isnt overriding super's play()");
	}
}

public class OverridingStaticMethodsError {
	public static void main(String[] args) {
		StaticPrivateOverriding sOb = new ChildStaticPrivateOverride();
		StaticPrivateOverriding.show(); //static show of father
	}

}
