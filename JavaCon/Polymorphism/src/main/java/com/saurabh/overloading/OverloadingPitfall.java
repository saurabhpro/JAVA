/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.overloading;

/**
 * Created by Saurabh on 7/30/2015.
 */
public class OverloadingPitfall {

	public static void main(String[] args) {
		OverloadingPitfall ob = new OverloadingPitfall();
		//ob.overload(4, 5); //Error:(38, 11) java: reference to overload is ambiguous [both method match]

		/*
		  single variable case wont produce ambiguous error
		 */
		ob.overload(6.7);
		ob.overload(6.7f);  //by default 6.7 exact matches to double so no error
		ob.overload(8);
		ob.overload(8L);

		/*
		  till the time we haven't called out class A method we dont seem to have a prob during compilation
		 */
		new OverloadingPitfall().createA();
		new OverloadingPitfall().createB();
	}

	void overload(int a, long b) {
		System.out.println("Inside Int long");
	}

	void overload(long a, int b) {
		System.out.println("Inside Long Int");
	}

	private void overload(int a) {
		System.out.println("Inside Int");
	}

	private void overload(long a) {
		System.out.println("inside Long");
	}

	private void overload(float a) {
		System.out.println("Inside Float");
	}

	private void overload(double a) {
		System.out.println("Inside double");
	}

	private void createA() {
		A a = new A();
		a.one(99);
	}

	private void createB() {
		B a = new B();
		a.one(99.0, 44);
	}

	/**
	 * compile time pe sab valid hai but when we call them on runtime ambiguity error ayega
	 */
	class A {
		void one(int a) {
			System.out.println("Int");
		}

		void one(long a) {
			System.out.println("long");
		}

		void one(float a) {
			System.out.println("float");
		}//reaches here if int and long not present

		void one(Integer a) {
			System.out.println("Integer");
		}//this will be executed in the end when no exact simple type match found

		void one(Double a) {
			System.out.println("Double");
		}//this will be executed in the end when no exact simple type match found and Integer is also not present
	}

	class B {
		void one(int a, double b) {
			System.out.println("Int");
		}

		void one(double a, double b) {
			System.out.println("double");
		}

		// if however double, int found then ambiguity error
		void one(Integer a, Double b) {
			System.out.println("Integer");
		}

		void one(float a) {
			System.out.println("float");
		}
	}


}

/*Output
Inside double
Inside Float
Inside Int
inside Long
long
double
 */