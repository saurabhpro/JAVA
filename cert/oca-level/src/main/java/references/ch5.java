package references;

interface Horn {
	public Integer play();
}

class B {
	static int f5() {
		return 0;
	}

	public String getName() {
		return "Unknown";
	}
}

abstract class A extends B {
	//int f5(){return 0;} not possible

	public static long b = 8L;
	protected final int a = 9;

	A() {
		super();
	}

	@Override
	public abstract String getName();

}

public class ch5 extends A {
	//private int b = 0;
	static long b = 4;      // there is nothing called variable overriding just hiding
	private int a = 8;

	public static void main(String[] args) {
		ch5 ob = new ch5();
		System.out.println(ob.a);

		A obj = (A) new ch5();
		//obj = (A) new B(); downcasting throws classcast exception

		//Exception ex = (ClassCastException) new Exception("Test");

		Exception ex = new Exception("Test");

		System.out.println(((ClassCastException) ex).getMessage()); //  and can't be downcasted with reference vaiable


		//the only valid way is chile ref in parent cant be downcasted
	}

	@Override
	public String getName() {
		return null;
	}
}

class OO {
//	void sh(String... k){}
//	void sh(String[] k){}
}

abstract class Woodwind {
	public Short play() {
		return 3;
	}
}
//
//public final class Saxophone extends Woodwind implements Horn {
//	public Integer play() {
//		return null;
//	}
//}







