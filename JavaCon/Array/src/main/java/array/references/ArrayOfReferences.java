/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package array.references;

/**
 * Created by Saurabh on 9/1/2015.
 */

class A {
	private static int x;

	int increment() {
		return x++;
	}
}

class B extends A {
	@Override
	int increment() {
		return super.increment();
	}
}

class C extends B {
	private static int x = 5;

	@Override
	int increment() {
		return x++;
	}
}

public class ArrayOfReferences {
	public static void main(String[] args) {
		A[] array = new C[4];       //Allowed but this is where the type converted into array.references.A

		for (A iOb : array) {
			iOb = new C();
			System.out.println(iOb.increment() + " " + iOb.getClass());     //upcasting while creating iOb
		}
	}
}
