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
class X {
}

@SuppressWarnings("ALL")
public class InitializationsPosition {

	/*instance initialization*/
	private final int y;
	X xOb1 = new X();
	private X xOb2;                        //by default null
	/* At the place of initialization*/
	private int x = 9;
	/*Inside constructor*/
	private int z;
	private String first, second;   //by default null as object

	/*Lazy Inialization => in functions where we want to use them*/
	private int value;              //by default 0  [already]

	{
		y = 10;
	}

	private InitializationsPosition(int tmp) {
		z = tmp;
	}

	//main method
	public static void main(String[] args) {
		InitializationsPosition iOb = new InitializationsPosition(88);
		System.out.println(iOb);    //implicitly calls toString()
	}

	public String toString() {
		System.out.println(xOb2);

		if (xOb2 == null) xOb2 = new X();
		if (first == null) first = "Hello";
		if (second == null) second = "World";
		if (value == 0) value = 99;

		return xOb2 + " " + first + " " + second + " " + value;
	}

}
