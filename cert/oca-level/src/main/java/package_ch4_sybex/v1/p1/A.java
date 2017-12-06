package package_ch4_sybex.v1.p1;

import package_ch4_sybex.v1.p2.ch4;


public class A {
	static protected int d = 9;
	static int b = 9;
	protected int e = 10;

	public static void main(String[] args) {
		ch4 ob = new ch4();
	}
}


class A2 {

	public A2() {
		this(8);
	}

	public A2(int x) {
		//calls super() implicitly
	}

	public static void main(String[] args) {
		A ob1 = new A();
		System.out.println(ob1.e);      // no inheritance needed
	}
}