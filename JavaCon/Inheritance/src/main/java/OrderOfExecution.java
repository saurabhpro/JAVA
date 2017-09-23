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
 * Created by Saurabh on 8/17/2015.
 */

@SuppressWarnings("All")
class Base {
	private static int y;   //class data member

	static {
		y = 2;
		System.out.println("Inside Static Block of base" + y);
	}

	private int x = 3;     //instance data member

	{
		System.out.println("Inside instance of base " + x);
	}

	Base(int i) {
		x = i;
		y = 0;
		System.out.println("Inside Constructor of base " + x + " " + y);
		//   show();
		//  show2();
	}

	static void show() {
		System.out.println("Inside Static Function base " + y);
	}

	void show2() {
		System.out.println("Inside regular function base " + x + " " + y);
	}
}

@SuppressWarnings({"SameParameterValue", "unused"})
class Child extends Base {
	private static int y = 4;   //class data member

	static {
		y = 9;
		System.out.println("\nInside Static Block of Child " + y);
	}

	private int x = 5;     //instance data member

	{
		System.out.println("Inside instance of child " + x);
	}

	Child(int i) {
		//super() fails as not present
		super(99);  //must be present   first statement in constructor, instance block follows it [check decompiled]

		x = i;
		y = 0;
		System.out.println("Inside Constructor child " + x + " " + y);
		//  show();
		//  show2();
	}

	static void show() {
		System.out.println("Inside Static Function child " + y);
	}

	void show2() {
		System.out.println("\nInside regular function child " + x + " " + y);
	}
}

public class OrderOfExecution {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//  Base b = new Base(5);
		//   b = new Base(6);     //static block wont be executed for this

		Child c = new Child(4);
		// c = new Child(14);
	}
}
