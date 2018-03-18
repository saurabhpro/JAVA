package Basics.dks;

class Base {
	public static String tString() {
		return "oo";
	}


	public static void m1() {
		System.out.println("Base");

	}
}


public class OverloadingAndOverriding extends Base {
	//public String tString(){
	//	return "oo";
	//} nahi chlega


	// not needed final but will not allow child class to have static method of same name, so allowed
	public static final void m1() {
		System.out.println("Child");
	}

	public static void main(String[] args) {
		Base obj = new Base();
		obj.m1();

		OverloadingAndOverriding t = new OverloadingAndOverriding();
		t.m1();

		Base i = new OverloadingAndOverriding();
		i.m1();
		//System.out.println(obj);
		//System.out.println(obj.toString());

		Object o = new String("saurabh");
		//StringBuffer sb = (StringBuffer) o;

		String s = "sa";
		s += o;
		s = s.intern(); // still not going to be true

		if (s == "sao") {
			System.out.println("uu");
		}
	}

	//final redundant but allowed
	private final void t() {

	}

	@Override
	public String toString() {
		return "chil";
	}
}


abstract class P {
	abstract void f();
}

abstract class C extends P {
	@Override
	abstract void f();
}

class C2 extends C {

	@Override
	void f() {

	}
}