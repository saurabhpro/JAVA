/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package exceptions.in_oops;

/**
 * Created by Saurabh on 9/2/2015.
 */

class A1 extends Exception {

}

/**
 * An overloaded method can throw whatever it wants
 */

class OverloadingException {

	Number show() {
		return null;    //ref abstraction in interfaces
	}
	// Integer show(){        return null;    } Not allowed as covarints

	void show(int i) {
	}

	//overloaded so good enough to throw whatever it likes
	void show(double d) {
	}
}
