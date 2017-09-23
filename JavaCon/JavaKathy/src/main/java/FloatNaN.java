/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import org.jetbrains.annotations.Contract;

/**
 * Created by Saurabh on 11/9/2015.
 */
public class FloatNaN {


	@Contract(pure = true)
	static int squareDivide(int x, int y) {
		int z = x * x / y * y;
		/*you would guess its 64/16 = 4 RIGHT!!!
	    but its pass by name

        (4+4)*(4+4)/(2+2)*(2+2);
        =8*8/4*4 = 8*2*4 = 64
        which is crazy isnt it!!!!
         */
		return z;
	}

	public static void main(String[] args) {
		System.out.println(1.0 / 3.0);        //Inexact Exception

		System.out.println(7.6 % 3.5);        //In java % works with floats

		//in java order of execution ensures same answer comes on every machine for these
		int d, a = 1, b = 2;
		d = a++ + ++b;
		System.out.println("a=" + a + " b=" + b + " d=" + d);

		int x = 5, y;
		y = x++ + ++x + ++x + x++ + x++;      //5+7+8+8+9 = 37(correct) but in c => 7*5 =35 (wrong)
		System.out.println("x=" + x + " y=" + y);

		int z, x1 = 7;
		z = x1++ + x1++ + ++x1;             //old c compiler give z=24, new gcc and java give 25
		System.out.println("x1=" + x1 + " z=" + z);

		System.out.println("Func = " + squareDivide((4 + 4), (2 + 2)));
	}
}
