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

/**
 * Created by Saurabh on 8/14/2015.
 */

@SuppressWarnings("All")
@FunctionalInterface
interface X {
	void show();
}

@SuppressWarnings("All")
@FunctionalInterface
interface Y {
	void show();
}

class XX implements X, Y {

	@Override
	// There can only be one implementation of this method.
	//C# has explicit Interface Implementation using explicit Interface Implementation
	// public class SampleClass : IControl, ISurface
	/*{
		void IControl.Paint()
		{
			System.Console.WriteLine("IControl.Paint");
		}
		void ISurface.Paint()
		{
			System.Console.WriteLine("ISurface.Paint");
		}
	}*///But!! Java doesn't -
	// but so far it didn't matter as there were no implementation so it would have cause no issue, or does it
	//if we change the return type of both implementation - we will be in trouble

    /*
    In java What you can do is compose a class out of two classes that each implement a different interface.
    Then that one class will have the behavior of both interfaces.

		class CompositeClass {
		    ISomething class1;
		    ISomething2 class2;
		    void doSomething1(){class1.doSomething();}
		    void doSomething2(){class2.doSomething();}
		}
     */

	public void show() {
		System.out.println("Hello X");
	}
}

public class DiamondProblemStillMadeSense extends XX implements Y {

	public static void main(String[] args) {
		DiamondProblemStillMadeSense d = new DiamondProblemStillMadeSense();
		d.show();
	}
}
