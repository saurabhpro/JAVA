/*
 * Copyright (c) 2018 Saurabh Kumar
 */

//package p1;

public class PFile1 {
	public static void main(String[] args) {
		new PFile1().show();
	}

	void show() {
		System.out.println("Inside package p1 show " + getClass().getName());
	}
}