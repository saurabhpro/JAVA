/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package generics;/* Simple generics with RunTimeTypeInformation*/

class Gen<T> {
	private final T var;

	Gen(T val) {
		this.var = val;
	}

	T getVar() {
		return var;
	}

	//Run Time Type Info Function
	void showType() {
		Class c = var.getClass();
		System.out.println("Type of T is :" + c.getName());
		//System.out.println("Type of T is :"+ var.getClass().getName());     way-2
	}
}

public class GenOne {
	public static void main(String[] args) {
		Gen<Integer> iOb = new Gen<>(88);      //or use diamond operator <> with constructor
		Gen<String> strOb = new Gen<>("Hello");

		System.out.println(iOb.getVar());
		iOb.showType();

		System.out.println(strOb.getVar());
		strOb.showType();

	}
}