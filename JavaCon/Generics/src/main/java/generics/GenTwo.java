/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package generics;

public class GenTwo {
	public static void main(String[] args) {
		Gen2<Integer, String> iOb = new Gen2<>(88, "Hello");      //or use diamond operator <> with constructor jdk16++
		Gen2<String, Double> strOb = new Gen2<>("Hello", 85.0);

		System.out.println(iOb.getVar() + " " + iOb.getVar2());
		iOb.showType();

		System.out.println(strOb.getVar() + " " + strOb.getVar2());
		strOb.showType();

		//System.out.println(strOb == iOb); Coz type alag hai

		Emp e1 = new Emp();
		Gen<Emp> eOb = new Gen<>(e1);
		eOb.showType();

		System.out.println(e1.x);
	}
}


class Gen2<T, V> {
	private final T var;
	private final V var2;

	Gen2(T val, V val2) {
		this.var = val;
		var2 = val2;
	}

	T getVar() {
		return var;
	}

	V getVar2() {
		return var2;
	}

	//Run Time Type Info Function
	void showType() {
		Class c = var.getClass();
		System.out.println("Type of T is : " + c.getName() + " Type of V is : " + var2.getClass().getName());
	}
}

class Emp<T> {
	final int x;

	Emp() {
		x = 15;
	}
}