/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.saurabh.special;

/**
 * Created by Saurabh on 8/17/2015.
 * When a java class is getting executed there are few steps which JVM performs few steps sequentially.
 * Identify the static members from top to bottom.
 * Executes static variables assignments and static blocks from top to bottom.
 * Executes the main method.
 * During these phases there is one such state called RIWO(Read Indirectly Write Only) for a static variable.
 * During RIWO a variable cannot be accessed directly with its reference.
 * Instead we need to use an indirect way to call certain variables.
 */
public class StaticFamily {
	public static void main(String... args) {
		RIWO.m1();
		System.out.println("block main");
	}

	static class SimpleExample {
		static final int j = 20;

		static {
			m1();
			System.out.println("first block");
		}

		static {
			System.out.println("second block");
		}


		static void m1() {
			System.out.println(j);
		}
	}

	static class RIWO {
		/**
		 * so how is this compiled?
		 * Pass 1
		 * First all the static variables are declared (no assignment)
		 * Then static methods are put - again only declartion
		 * The static block is placed - only declarion
		 * <p>
		 * Until this point all the variables are in RIWO state (Read Indirectly Write Only)
		 * Pass 2
		 * Execution begins in the order of original declaration
		 * so i = 10 but j gets values after static block is excuted - as per the written order
		 * so for now j = 0
		 * <p>
		 * the static block is executed - if j = 330 before calling m1() , it is assigned
		 * when m1() is encountered - its content is executed
		 * <p>
		 * if no method is called from static block - static method is executed as per the order of writing
		 * the rearranged RIWO state allowed static blocks to call static methods - since there declartion has already done
		 * <p>
		 * As per JLS static variables that are not yet defined can only be used in the assignment unless they are prefixed with class name(in which case they get there default value). E.g.1
		 * <p>
		 * static {
		 * i = 3;
		 * i = i * 2; // will give you compile error
		 * System.out.println("Hello World!" );
		 * }
		 * E.g.2 In this case you are accessing variable i prefixed with class name. But remember that revi.i will have value 0 not 15, so the output will be 0
		 * <p>
		 * static {
		 * i = revi.i * 2; // this line is similar to  revi.i = revi.i * 2;
		 * System.out.println("Hello World!" + revi.i );
		 * }
		 * static int i = 15;
		 * <p>
		 * <p>
		 * In case 3 first you declared and initialize i=5 and then assigned 3 to it. So after initialization i will hold 3 as its value
		 */

		static final int i = 10;
		static int j = 20;

		static {
			//System.out.println(j);    //illegal forward reference as at this stage j is in RIWO
			//j=j+20;   //again forward reference so error
			j = 330;  //is allowed as it is assignment - but still in RIWO state


			// call the variable indirectly using a method.
			m1();   // using a method it is allowed as j will have value 0 if not assigned

			System.out.println(m2());   //no forward reference error
			System.out.println("block1");
		}

		static {
			System.out.println("end of code");
			m2();
		}


		RIWO() {
			System.out.println("Hey");
		}

		static void m1() {
			System.out.println(i);
			System.out.println(j);

			System.out.println("block m1");
		}

		static int m2() {
			System.out.println("Block 2 - ");
			return 6;
		}
	}


}