/*
 * Created by Saurabh on 8/30/2015.
 */

/**
 * You can use inner classes to implement helper classes. To handle user interface events,
 * you must know how to use inner classes, because the event-handling mechanism makes extensive use of them.
 */
@SuppressWarnings("ALL")
public class OuterSimpleInner {
	private static final int n = 9;

	static {
		System.out.println("static block of outer");
	}

	private final int m = 10;

	{
		System.out.println("Init of outer");
	}

	private static void show() {
		System.out.println("OuterSimpleInner Static method");
	}

	public static void main(String[] args) {
		OuterSimpleInner ob = new OuterSimpleInner();
		OuterSimpleInner.Inner oi = ob.new Inner();
		oi.show();


		MyOuter out = new MyOuter();

		out.makeInner();            //either have a function in MyOuter class which makes the object
		//or
		MyOuter.MyInner inr = out.new MyInner();    //do it from here
		//or in one line
		MyOuter.MyInner in2 = new MyOuter().new MyInner();
		inr.seeOuter();
	}

	private void display() {
		System.out.println("OuterSimpleInner Non-Static method");
	}

	private class Inner {
		//    static int x = 99;        //cannot have static declaration in [non-static] inner class
		//static (with final) is allowed in Inner classes as they combined with final make constant value
		static final int z = 66;
		int y = 110;

		// static {    int y = 110;     }
		{
			System.out.println("Inside init of inner");
		}

		Inner(OuterSimpleInner s) {
			System.out.println("Inside Inner para constructor");
		}

		Inner() {
			System.out.println("Inside Inner non para constructor");
		}

		void show() {
			System.out.println(n + " " + m);        //static variable from outer = n allowed
			System.out.println("OuterSimpleInner class reference " + OuterSimpleInner.this);
			System.out.println("Inner class reference " + this);

			OuterSimpleInner.this.display();       //only display wont work as it'll look for this.display() which isnt there!
			OuterSimpleInner.show();   //or OuterSimpleInner.this.show();
		}
	}

}

@SuppressWarnings("ALL")
class MyOuter {
	private final int i = 7;

	/**
	 * if we make this function static , we cannot create the instance of inner here as MyOuter.this wont work
	 * inside static field there is no this, similarly getClass() wont work as non-static function
	 */
	public void makeInner() {

		System.out.println("\n\n" + getClass());     //this.getClass())

		//Inner class instances are always handed an implicit reference of outer class
		MyInner in = new MyInner();             //implicitly  MyOuter.MyInner in = new MyOuter.MyInner();
		in.seeOuter();
		System.out.println(in.getClass());      //this ke badle in
	}

	//Inner class are fine , what about inner interfaces
	interface x {
	}   //valid

	//all these are allowed for normal inner classes
	private static class inner2 {
	}        //this basically is nested class

	class MyInner {
		public void seeOuter() {
			System.out.println("OuterSimpleInner x is : " + i);      //  MyOuter.this.i

			System.out.println(getClass());             //this.getClass())

		}
	}

	private abstract class inner3 {
	}

	private final class inner4 {
	}

	private strictfp class inner5 {
	}

}