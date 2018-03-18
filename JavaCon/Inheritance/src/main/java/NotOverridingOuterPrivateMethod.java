/*
 * Copyright (c) 2018 Saurabh Kumar
 */

/**
 * Java program to demonstrate whether we can override private method
 * of outer class inside its inner class
 */
public class NotOverridingOuterPrivateMethod {
	private String msg = "GeeksforGeeks";

	public static void main(String args[]) {

		// In order to create instance of Inner class, we need an Outer
		// class instance. So, first create Outer class instance and then
		// inner class instance.
		NotOverridingOuterPrivateMethod o = new NotOverridingOuterPrivateMethod();
		Inner i = o.new Inner();

		// This will call Inner's fun, the purpose of this call is to
		// show that private members of Outer can be accessed in Inner.
		i.fun();

		// o.fun() calls Outer's fun (No run-time polymorphism).
		o = i;
		o.fun();
	}

	private void fun() {
		// if this method was public - we would be overriding, but private is bound at compile time
		System.out.println("Outer fun()" + msg);
	}

	class Inner extends NotOverridingOuterPrivateMethod {
		//@Override - not overriding!
		public void fun() {
			System.out.println("Accessing Private Member of Outer: " + msg);
		}
	}
}

/*
Output:

Accessing Private Member of Outer: GeeksforGeeks
Outer fun()
In the above program, we created an outer class and an inner class.
We extended Inner from Outer and created a method fun() in both Outer and Inner.

If we observe our output, then it is clear that the method fun() has not been overriden.
It is so because private methods are bonded during compile time and it is the type of the reference variable
– not the type of object that it refers to – that determines what method to be called.

As a side note, private methods may be performance-wise better (compared to non-private and non-final methods)
due to static binding.
 */