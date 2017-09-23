/**
 * Created by Saurabh on 8/17/2015.
 */

@SuppressWarnings("All")
class Base {
	private static int y;   //class data member

	static {
		y = 2;
		System.out.println("Inside Static Block of base" + y);
	}

	private int x = 3;     //instance data member

	{
		System.out.println("Inside instance of base " + x);
	}

	Base(int i) {
		x = i;
		y = 0;
		System.out.println("Inside Constructor of base " + x + " " + y);
		//   show();
		//  show2();
	}

	static void show() {
		System.out.println("Inside Static Function base " + y);
	}

	void show2() {
		System.out.println("Inside regular function base " + x + " " + y);
	}
}

@SuppressWarnings({"SameParameterValue", "unused"})
class Child extends Base {
	private static int y = 4;   //class data member

	static {
		y = 9;
		System.out.println("\nInside Static Block of Child " + y);
	}

	private int x = 5;     //instance data member

	{
		System.out.println("Inside instance of child " + x);
	}

	Child(int i) {
		//super() fails as not present
		super(99);  //must be present   first statement in constructor, instance block follows it [check decompiled]

		x = i;
		y = 0;
		System.out.println("Inside Constructor child " + x + " " + y);
		//  show();
		//  show2();
	}

	static void show() {
		System.out.println("Inside Static Function child " + y);
	}

	void show2() {
		System.out.println("\nInside regular function child " + x + " " + y);
	}
}

public class OrderOfExecution {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//  Base b = new Base(5);
		//   b = new Base(6);     //static block wont be executed for this

		Child c = new Child(4);
		// c = new Child(14);
	}
}
