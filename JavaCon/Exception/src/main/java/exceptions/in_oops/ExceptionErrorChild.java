package exceptions.in_oops;

/**
 * Created by Saurabh on 8/16/2015.
 */

class Parent extends Exception {
	Parent(String str) {
		super(str);     //passes to Exceptions constructor
	}

	Parent() {
		super();
	}

	@Override
	public String getMessage() {
		return "Detail Message: " + super.getMessage();
	}
}

class Child extends Parent {
	Child() {
		super();
	}

	Child(String str) throws Child {
		super(str);
		throw new Child(str);
		/* java supports two type of throw statement [all standard exceptions have these
		  if you have your own class, provide these
		  1. throw new child() //default constructor
		  2. throe new child("String Arguments"); //string argument which can be late printed
		  Exception class has these two constructors
		 */
	}
}

public class ExceptionErrorChild {
	public static void main(String[] args) throws Child {
		try {
			Parent c = new Child("Hi");
		} catch (Exception e) {
			System.out.println("exceptions.in_oops.Child caught: " + e.getMessage());
			//    e.printStackTrace(System.out);
		}
	}
}
