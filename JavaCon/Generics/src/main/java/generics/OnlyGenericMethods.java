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

import java.util.ArrayList;

/**
 * Created by Saurabh on 8/13/2015.
 */
public class OnlyGenericMethods {

	private static <T> void showVal1(T x) {
		System.out.println(x);
		System.out.println(x.getClass().getName() + "\n");
	}

	private static <T extends Number> void showVal2(T x) {
		System.out.println(x);
		System.out.println(x.getClass().getName() + "\n");

	}

	public static void main(String[] args) {
		OnlyGenericMethods gm = new OnlyGenericMethods();

		gm.showType("");
		gm.showType(76);    //autoboxing Automatic Type Inference

		showVal1("Hello");
		OnlyGenericMethods.showVal2(96.8f);     //static method

		/*
		showVal2("Hello");

        Error:(21, 9) java: method showVal2 in class generics.OnlyGenericMethods cannot be applied to given types;
          required: T
          found: java.lang.String
          reason: inferred type does not conform to upper bound(s)
            inferred: java.lang.String
            upper bound(s): java.lang.Number
         */
	}

	private <T> void showType(T x) {
		System.out.println(x);
		System.out.println(x.getClass().getName() + "\n");
	}

}
