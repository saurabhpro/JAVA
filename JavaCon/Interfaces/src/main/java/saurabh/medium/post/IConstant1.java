/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.medium.post;

public interface IConstant1 {
	String Hello = "Hi There";
}

interface IConstant2 extends IConstant1 {
	String Hello = "Hi There Numbr 2";
	// here it doesn't matter if we are extending IConstant1, static things does not override, but re-declared!
}

class Tester2 implements IConstant1 {
	public static void main(String[] args) {
		System.out.println(Tester2.Hello);      // surprised much - this works
		System.out.println(IConstant2.Hello);      // this will work as well
	}
}

class Tester implements IConstant1, IConstant2 {
	public static void main(String[] args) {

		//System.out.println(Tester.Hello);       // This is error
		/*
		Error:(24, 42) java: reference to Hello is ambiguous
	    both variable Hello in IConstant1 and variable Hello in IConstant2 match
		 */

		// but
		System.out.println(IConstant1.Hello);
		System.out.println(IConstant2.Hello);
		// is not

		/* OUTPUT
		Hi There
		Hi There Numbr 2
		 */
	}
}
