/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.medium.post;

interface IC1 {
	default void show() {

	}
}

class C1 implements IC1 {

	@Override
	public void show() {

	}
}

class c2 extends C1 implements IC1 {

}
