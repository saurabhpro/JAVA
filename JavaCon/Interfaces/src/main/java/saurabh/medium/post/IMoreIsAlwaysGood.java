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

interface ITestDrive {
	String MODEL_NAME = "Durant"; //implicit public + static + final

	void getCustomerId(); // implicit public + abstract
}

interface IMoreIsAlwaysGood {
	int MADE = 100;        // I can't be private!

	static void makeThis() {
		System.out.println("check it - I'm static - you can't override me like default, you can also make me private and you can also make methods with name same as me in inheriting interfaces and classes - cheers Mate!");
	}

	default void show() {
		System.out.println("I'm a default method in Interface and yes I'm not abstract but you can always override me in any inheriting Interface or implementing Class!\n Also I can't be private since I'm already 'default'");
	}

	private void youCantSeeMe() {
		System.out.println("If you don't belong in this - you can't see me");
	}


	void guessWhat();
}