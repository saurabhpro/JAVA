/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

/**
 * Created by Saurabh on 8/14/2015.
 */
@SuppressWarnings("unused")
public class CircularInheritance {
	public static void main(String[] args) {
		B b = new B();

	}
}

//class B extends  A{}

/**
 * class A extends B{}
 * class B extends C{}
 * class C extends A{}  // this will give you compile time error. [in c++. C# too]
 * <p>
 * The super class must be initialized first then only it can be extended.
 * Cycle creates infinite loop
 */

class B {
	B() {
		System.out.println("B");

	}
}

class A extends B {
	A() {
		System.out.println("A");
	}
}


