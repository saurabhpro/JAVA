/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package saurabh.Interface.diamondProblem;

interface FirstFile1 {
	default void checkThis() {
		System.out.println("Im in Parent 1");
	}
}

interface SecondFile2 {
	default void checkThis() {
		System.out.println("Im in Parent 2");
	}
}

public class DiamondProblemWithDefaultSolvedByJava implements SecondFile2, FirstFile1 {

	public static void main(String[] args) {
		DiamondProblemWithDefaultSolvedByJava tester = new DiamondProblemWithDefaultSolvedByJava();
		tester.checkThis();
	}

	/**
	 * Java 8 addresses this by requiring you to provide an implementation for the ambiguous method
	 * in the relevant class, in this case DiamondProblemWithDefaultSolvedByJava.
	 */
	@Override
	public void checkThis() {
		SecondFile2.super.checkThis();
	}
}