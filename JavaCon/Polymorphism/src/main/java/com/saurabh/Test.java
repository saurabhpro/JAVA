/*
 * Copyright 2017 Saurabh Kumar 29/10/17 11:21 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.saurabh;

class Test {
	int a = 1;
	int b = 2;

	public static void main(String[] args) {
		Test obj1 = new Test();
		Test obj2 = obj1.func(obj1);

		System.out.println("obj1.a = " + obj1.a + "  obj1.b = " + obj1.b);
		System.out.println("obj2.a = " + obj2.a + "  obj1.b = " + obj2.b);

	}

	Test func(Test obj) {
		Test obj3 = new Test();
		obj3 = obj;
		obj3.a = obj.a++ + ++obj.b;
		obj.b = obj.b;
		return obj3;
	}
}