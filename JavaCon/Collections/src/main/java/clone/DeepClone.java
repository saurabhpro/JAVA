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


class Temp2 implements Cloneable {
	int g;

	Temp2(int g) {
		this.g = g;
	}

	@Override
	public Temp2 clone() {
		try {
			return (Temp2) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}

public class DeepClone implements Cloneable {
	private int x = 10;
	private final Temp2 t;

	@SuppressWarnings("SameParameterValue")
	private DeepClone(int a) {
		t = new Temp2(a);
	}

	public static void main(String[] args) {
		DeepClone c = null;
		DeepClone m = new DeepClone(100);
		System.out.println(m.t.g);
		System.out.println(m.x);
		try {
			c = m.clone();
			//c.t  = m.t.clone()
		} catch (Exception ignored) {
		}

		assert c != null;       //own code

		System.out.println(c.t.g);
		System.out.println(c.x);

		c.t.g = 350;
		c.x = 35;

		System.out.println("M after changes " + m.t.g);
		System.out.println("M after changes " + m.x);

		if (m.t == c.t)
			System.out.println("My Deep Cloning");
	}

	@Override
	public DeepClone clone() {
		try {
			System.out.println("Inside Deep");
			DeepClone d1 = (DeepClone) super.clone();
			d1.t.clone();

			return d1;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
