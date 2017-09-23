/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.saurabh;

//simple Java method main (method main does not call any other methods)

import java.util.Scanner;

public class Java_Method_main //change class name to the class you are creating 
{
	//global variables (fields in OOP)
	private Scanner input;

	public static void main(String args[]) //required method main for an executable class
	{
		System.out.println("Hello");
		Java_Method_main program = new Java_Method_main();
		program.main();
	}

	private void main() //non-static method main that can call non-static methods
	{
		//create a Scanner object for console input
		input = new Scanner(System.in);  //create Scanner input object

		//enter your method main statements here
	}

	//enter additional methods here

}