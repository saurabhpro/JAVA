/*
 * Copyright (c) 2018 Saurabh Kumar
 */

/*
 * Created by Saurabh on 8/30/2015.
 * <p>
 * starting in Java SE 8, a local class can access local variables and parameters of the enclosing block
 * that are final or effectively final.
 * A variable or parameter whose value is never changed after it is initialized is effectively final.
 * For example, suppose that the variable numberLength is not declared final, and you add the highlighted assignment
 * statement in the PhoneNumber constructor:
 * <p>
 * PhoneNumber(String phoneNumber) {
 * numberLength = 7;
 * String currentNumber = phoneNumber.replaceAll(regularExpression, "");
 * if (currentNumber.length() == numberLength)
 * formattedPhoneNumber = currentNumber;
 * else
 * formattedPhoneNumber = null;
 * }
 * Because of this assignment statement, the variable numberLength is not effectively final anymore.
 * As a result, the Java compiler generates an error message similar to
 * "local variables referenced from an inner class must be final or effectively final"
 * where the inner class PhoneNumber tries to access the numberLength variable:
 */

/**
 * You can define a local class inside any block (see Expressions, Statements, and Blocks for more information).
 * For example, you can define a local class in a method body, a for loop, or an if clause.
 */


class MyOuter2 {
	private static final int y = 11;
	private final int x = 10;
	private int num = 9;

	static void show() {
		System.out.println("Inside Outer static method");
	}

	/**
	 * since the method is static, its local inner class can only access the static members of the enclosing outer class
	 *
	 * @param st just
	 */
	static void doOtherStuff(String st) {
		/*Local classes are non-static because they have access to instance members of the enclosing block.
		 *         Consequently, they cannot contain most kinds of static declarations.
		 */
		class LocalInnerTwo {
			void show() {
				System.out.println("Inside static method Local inner " + getClass());
				//System.out.println(x);          //cannot use x here as x is non-static in MyOuter2
				System.out.println(y);              //valid
			}
		}
		//noinspection ParameterCanBeLocal
		class LocalInnerThree extends LocalInnerTwo {

			//static (with final) is allowed in Local inner classes as they combined with final make constant value
			static final int ou = 9;

			@Override
			void show() {
				System.out.println("Inside static method Local inner " + getClass());
			}

			void show2(String str)      //no inner class can have static declaration unless for constants
			{
				//Starting in Java SE 8, if you declare the local class in a method, it can access the method's parameters.
				//till java 7 this was an error

				str = "hello";        //yhan effective final wala scene nhi hai, valid in jdk 7-8 all
				//accessing argument of doOtherStuff however need final or effective final in jdk 7
				//from jdk 8 final or or effective final both work

				System.out.println(str + " " + st + " world");
			}
		}


		//only these modifiers allowd with local inner classes
		abstract class LocalInnerFour {
		}
		final class LocalInnerFive {
		}


		/*
		 * You cannot declare an interface inside a block; interfaces are inherently static.
		 * For example, the following code excerpt does not compile because the interface xyz is defined inside the body of the method
		 *
		 * interface xyz{}
		 */


		LocalInnerTwo in = new LocalInnerTwo();
		in.show();
		LocalInnerThree inv = new LocalInnerThree();
		inv.show();
		inv.show2("Hi");
	}

	public void display() {
		System.out.println("Inside Outer non static method");
	}

	void doStuff() {
		final int temp = 8;           //local variable can only be final , no other modifier allowed here
		class LocalInner {
			MyOuter2 ob = new MyOuter2();

			void show() {
				//temp =9;       compiler sees that temp hasn't changed so it is effectively final and hence valid for local class
				System.out.println(temp + "Inside Local inner " + getClass());
				System.out.println(x + " " + y);    //accessing both static and non static instance variables of enclosing class
			}
		}
		LocalInner in = new LocalInner();
		in.show();
	}
}

public class MethodLocalInnerClass {
	public static void main(String[] args) {
		MyOuter2 mOb = new MyOuter2();
		mOb.doStuff();
		MyOuter2.doOtherStuff("Cool");
	}
}
