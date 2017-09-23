/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package clone;

/**
 * Created by Saurabh on 9/6/2015.
 */

class Temp1 {
	int g;

	Temp1(int g) {
		this.g = g;
	}
}


class ShallowClone implements Cloneable {
	private int x = 10;
	private final Temp1 t;

	@SuppressWarnings("SameParameterValue")
	private ShallowClone(int a) {
		t = new Temp1(a);
	}

	public static void main(String[] args) {
		ShallowClone c;
		ShallowClone m = new ShallowClone(100);

		System.out.println(m.t.g);
		System.out.println(m.x);

		c = m.clone();

		System.out.println(c.t.g);
		System.out.println(c.x);

		c.t.g = 300;        //since referring to same object, changes actual value
		c.x = 30;           //changes only its own object state

		System.out.println("M after Changes " + m.t.g);     //prints 300
		System.out.println("M after Changes " + m.x);

		if (m.t == c.t) {
			System.out.println("Shallow Copy Reference same!!!");
		}
	}

	//clone has protected access in Object class, so inheritance tree ke bahar se nhi call kar skte
	//clone returns Object
	@Override
	public ShallowClone clone() {
		try {
			return (ShallowClone) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
