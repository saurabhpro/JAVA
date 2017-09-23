/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

public class ByteExpression {
	public static void main(String[] args) {
		byte a = 9;
		byte b = 10;
		//byte c = a+ b; error
		//Otherwise, if the operand is of compile-time type byte, short, or char,
		// it is promoted to a value of type int by a widening primitive conversion (�5.1.2).

		a++;
		a += 7;
		//a = a+7;  error

        /*Because b += 1 is an equivalent to b = (byte)(b + 1), whereas type of b + 1 is promoted to int
        (JLS �5.6.2 Binary Numeric Promotion)
        and therefore its result cannot be assigned to byte without explicit conversion.

        From JLS, �15.26.2 Compound Assignment Operators:

        A compound assignment expression of the form E1 op= E2 is equivalent to E1 = (T)((E1) op (E2)),
        where T is the type of E1, except that E1 is evaluated only once.*/

		//BUT
		/*
		From the JLS 5.2 Assignment Conversion

        In addition, if the expression is a constant expression (�15.28) of type byte, short, char, or int:
        - A narrowing primitive conversion may be used if the type of the variable is byte, short, or char,
        and the value of the constant expression is representable in the type of the variable.

        In short the value of the expression (which is known at compile time, because it is a constant expression)
        is representable in the type of the variable that is byte.

        Consider your expression
    */
		final byte x = 1;
		final byte y = 2;
		byte z = x + y;//This is constant expression and value is known at compile time
		//So as summation fits into byte it does not raise an compilation error.

    /*
        Now if you do

        final byte x = 100;
        final byte y = 100;
        byte z = x + y;// Compilation error it no longer fits in byte*/

		System.out.println("Hello World!");
	}
}