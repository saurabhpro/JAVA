/*
 * Copyright (c) 2018 Saurabh Kumar
 */

/**
 * Created by Saurabh on 8/31/2015.
 */

interface Incrementable {
	void increment();
}

class Callee1 implements Incrementable {
	private int i = 0;

	Callee1() {
		System.out.println("Inside Callee1");
	}

	public void increment() {           //implements method in Incrementable
		i++;
		System.out.println("Callee1 " + i);
	}
}

class MyIncrement {
	MyIncrement() {
		System.out.println("Inside MyIncrement");
	}

	static void f(MyIncrement mi) {
		mi.increment();
	}

	void increment() {
		System.out.println("Other Operation");
	}
}

class Callee2 extends MyIncrement {
	private int i = 0;

	Callee2() {
		System.out.println("Inside Callee2");
	}

	void increment() //overriding MyIncrement.increment()
	{
		super.increment();
		i++;
		System.out.println("Callee2 " + i);
	}

	Incrementable getCallbackReference() {
		return new Closure();       //     return new Callee2.Closure(null);
	}

	private class Closure implements Incrementable {
		Closure() {
			System.out.println("Inside Closure");
		}

		public void increment() //implements method of Incrementable
		{
			Callee2.this.increment();
		}
	}
}

class Caller {
	private final Incrementable callBackReference;

	Caller(Incrementable eh) {
		System.out.println("Inside Caller\t");
		callBackReference = eh;     //this.callBackReference = eh;
	}

	void go() {
		callBackReference.increment();
	}
}

public class Callbacks {

	Callbacks() {
		System.out.println("Inside Callbacks");
	}

	public static void main(String[] args) {
		Callee1 c1 = new Callee1();
		System.out.println();

		Callee2 c2 = new Callee2();
		System.out.println();

		MyIncrement.f(c2);      //overriden by upcasting so Callee2 wala chalega by c2
		System.out.println();

		Caller caller1 = new Caller(c1);
		System.out.println();

		Caller caller2 = new Caller(c2.getCallbackReference());
		System.out.println();

		caller1.go();
		caller1.go();

		caller2.go();
		caller2.go();
	}
}


/*
Inside Callee1

Inside MyIncrement
Inside Callee2

Other Operation
Callee2 1

Inside Caller

Inside Closure
Inside Caller

Callee1 1
Callee1 2
Other Operation
Callee2 2
Other Operation
Callee2 3

 */