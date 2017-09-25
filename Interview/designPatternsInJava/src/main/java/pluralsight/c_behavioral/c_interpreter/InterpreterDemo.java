/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.c_behavioral.c_interpreter;

public class InterpreterDemo {

	private static Expression buildInterpreterTree() {

		Expression terminal1 = new TerminalExpression("Lions");
		Expression terminal2 = new TerminalExpression("Tigers");
		Expression terminal3 = new TerminalExpression("Bears");

		// Tigers and Bears
		Expression alternation1 = new AndExpression(terminal2, terminal3);

		//Lions or (Tigers and Bears)
		Expression alternation2 = new OrExpression(terminal1, alternation1);

		return new OrExpression(terminal1, alternation1);
	}

	/**
	 * main method - build the interpreter and then interpret a specific
	 * sequence
	 */
	public static void main(String[] args) {

		//String context = "Lions";
		//String context = "Tigers";
		//String context = "Bears";
		//String context = "Lions Tigers";
		//String context = "Lions Bears";
		String context = "Tigers Bears";

		Expression define = buildInterpreterTree();

		System.out.println(context + " is " + define.interpret(context));
	}
}
