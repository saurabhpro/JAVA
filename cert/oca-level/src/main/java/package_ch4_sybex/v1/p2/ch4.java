package package_ch4_sybex.v1.p2;

import package_ch4_sybex.v1.p1.A;

public class ch4 extends A {
	public static void main(String[] args) {
		// System.out.println(b); not possible since b has Default access specifier in base class
		System.out.println(d); //possible since d has Protected
	}

	public static final void walk3() {
	}

	public final static void walk4() {
	}

	//public modifier void walk5() {} // DOES NOT COMPILE
	//public void final walk6() {} // DOES NOT COMPILE

	static final public void walk7() {
	}

	public void set5() {
		System.out.println(e);  // protected in different package but accessible via inheritance
	}
}


class ch4_1 extends ch4 {
	@Override
	public void set5() {
		System.out.println(e);
	}
}

class ch4_2 {
	public static void main(String[] args) {
		ch4_1 ob = new ch4_1();
		// System.out.println(ob.e); e is behaving private like
		/*
		No! Once the subclass-outside-the-package inherits the protected member, that member
		(as inherited by the subclass) becomes private to any code outside the subclass, with the exception
		of subclasses of the subclass. So if class Neighbor instantiates a Child object, then even
		if class Neighbor is in the same package as class Child, class Neighbor won’t have access
		to the Child’s inherited (but protected) variable x.

		 */
	}
}

class B {
	void main() {
		A ob = new A();
		// System.out.println(ob.d); not subclassed and also not in same package - so not possible

		// default and protected are cool only in same packages
	}
}