/*
 * Created by Saurabh on 8/30/2015.
 */

/**
 * While local classes are class declarations, anonymous classes are expressions,
 * which means that you define the class in another expression.
 * <p>
 * while local classes are class declarations, anonymous classes are expressions,
 * which means that you define the class in another expression..
 * <p>
 * The anonymous class expression consists of the following:
 * <p>
 * <ul>
 * <li>The new operator</li>
 * <li>The name of an interface to implement or a class to extend. In this example,
 * the anonymous class is implementing the interface HelloWorld.</li>
 * <li>Parentheses that contain the arguments to a constructor, just like a normal class instance creation expression.
 * Note: When you implement an interface, there is no constructor, so you use an empty pair of parentheses, as in this example.</li>
 * <li>A body, which is a class declaration body. More specifically, in the body, method declarations are allowed but statements are not.</li>
 * <li> Because an anonymous class definition is an expression, it must be part of a statement.</li>
 * </ul>
 * <p>
 */


public class LocalClass {

	public static void main(String[] args) {
		LocalClass aOb = new LocalClass();
		aOb.doStuff();
	}

	void doStuff() {
		class Popcorn {
			void pop() {
				System.out.println("Poped PopCorn");
			}
		}

		class Food {
			Popcorn p = new Popcorn() {
				@Override
				void pop() {
					System.out.println("Popped anonymous popcorn!!");
				} //overides base class Popcorn's pop method
			};

			/* here we are creating a subclass of Cookable which is basically an implementer class*/

			/**
			 * since java 8 we can use Lambda expressions to provide an implementation for interface via anonymous class
			 * Cookable c = () -> System.out.println("Anonymous cookable implementer!!");         //one function only
			 */

			Cookable c = new Cookable() {
				@Override
				public void cook() {
					System.out.println("Anonymous cookable implementer!!");
				}//implements method cook if interface cookable

				@Override
				public void wash() {
					System.out.println("Anonymous Wash in");
				}
			};
		}
		Food fOb = new Food();
		fOb.p.pop();

		fOb.c.cook();
		fOb.c.wash();

	}


	interface Cookable {
		void cook();

		void wash();
	}   //interfaces method ke scope me nhi likh skte
}
