/*
 * Copyright (c) 2018 Saurabh Kumar
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
