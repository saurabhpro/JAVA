/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package saurabh.Interface.Java8;
/*
 * Created by Saurabh on 8/30/2015.
 */

/**
 * SINCE JAVA 8... these are added
 * In addition to default methods, you can define static methods in interfaces.
 * (A static method is a method that is associated with the class in which it is defined rather than with any object.
 * Every instance of the class shares its static methods.)
 * This makes it easier for you to organize helper methods in your libraries; you can keep static methods specific
 * to an interface in the same interface rather than in a separate class.
 * <p>
 * <p>
 * A static method is a method that applies to the class 'namespace', so to speak.
 * So a static method foo of interface Interface is accessed by Interface.foo().
 * Note that the function call does not apply to any particular instance of the interface.
 * <p>
 * A default implementation bar on the other hand, is called by
 * Interface x = new ConcreteClass();
 * x.bar();
 * <p>
 * A static interface method cannot know about the this variable, but a default implementation can.
 */

interface Runnable {

	int NUM = 9;                // implicitly  public static final to make constants

	//bytecode static default void distance() {...}     "default" implicitly pasted
	static void distance() {
		System.out.println("Inside saurabh.Interface.Java8.Runnable static method " + NUM);
	}

	/**
	 * Error:(27, 25) java: static interface methods are not supported in -source 1.7
	 * (use -source 8 or higher to enable static interface methods)
	 * <p>
	 * Error:(33, 5) java: default methods are not supported in -source 1.7
	 * (use -source 8 or higher to enable default methods)
	 */

	void main();    //since these methods are by default "abstract" they cannot be made strictfp , final, or static

	default void show() {
		System.out.println("inside interfaces default method:\n\t" +
				"which is fully declared and cannot be overridden?" + this.getClass());
	}
}

interface Walkable extends Runnable {
	// We cant provide it a body here

	/**
	 * When you extend an interface that contains a default method, you can do the following:
	 * 1. Not mention the default method at all, which lets your extended interface inherit the default method.
	 * 2. Redeclare the default method, which makes it abstract.
	 * 3. Redefine the default method, which overrides it.
	 */

	int NUM = 6;        // locally declaring it

	//void show();   valid case 2
	@Override   //case 3
	default void show() {
		System.out.println("Inside child interfaces show() - Overridden " + NUM);
	}


	@SuppressWarnings("unused")
	void distance();        //not overriding superclass distance here


}

public class InterfaceContract implements Walkable, Runnable {
	//void show(){}; // ERROR as we have to make every interface functions public...maintain visibility

	private InterfaceContract() {
		// NUM = 8;      cannot reassign it, but can be hidden

	}

	public static void main(String[] args) {
		//Valid

		Walkable wOb = new InterfaceContract();
		Runnable rOb = new InterfaceContract();
		InterfaceContract iOb = new InterfaceContract();


		rOb.show();     //if overridden in child interface, that is used when name collision occurs
		wOb.show();
		iOb.show();

		wOb.main();

		//invalid   wOb/rOb/iOb.distance()  only class access possible

		Runnable.distance();        //valid
		//Walkable.distance();      //static method can be invoked on containing interfaces only

	}

	@Override
	public void main() {
		System.out.println("Inside " + this.getClass());
	}

	@Override
	public void distance() {
		//noinspection unused
		int f = 9;
	}        //overriding walkable show

}


/*
 * public interface DoIt {
 * void doSomething(int i, double x);
 * int doSomethingElse(String s);
 * }
 * <p>
 * If you want to add additional methods to an interface, you have several options.
 * <p>
 * 1. You could create a DoItPlus interface that extends DoIt:
 * public interface DoItPlus extends DoIt {
 * boolean didItWork(int i, double x, String s);
 * }
 * Now users of your code can choose to continue to use the old interface or to upgrade to the new interface.
 * <p>
 * <p>
 * 2. Alternatively, you can define your new methods as default methods.
 * The following example defines a default method named didItWork:
 * <p>
 * public interface DoIt
 * {
 * void doSomething(int i, double x);
 * int doSomethingElse(String s);
 * default boolean didItWork(int i, double x, String s) {
 * // Method body
 * }
 * }
 * Note that you must provide an implementation for default methods.
 * <p>
 * You could also define new static methods to existing interfaces.
 * Users who have classes that implement interfaces enhanced with new default or static methods
 * do not have to modify or recompile them to accommodate the additional methods.
 */