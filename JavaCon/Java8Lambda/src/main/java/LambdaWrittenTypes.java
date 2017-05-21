/**
 * Created by Saurabh on 10/31/2015.
 * <p>
 * lambda expression is not a method, although its declaration looks similar to a method. As the name suggests, a lambda
 * expression is an expression that represents an instance of a functional interface.
 * <p>
 * Example: (String str) -> str.length() What is the type of this lambda expression? The answer is that we do not know.
 * By looking at the lambda expression, all you can say is that it takes a String parameter and returns an int, which is
 * the length of the String.
 * <p>
 * Its type can be any functional interface type with an abstract method that takes a String as a parameter and returns
 * an int. A lambda expression by itself does not have a type, and therefore, it cannot be used as a standalone
 * expression. The type of a lambda expression is always inferred by the compiler by the context in which it is used.
 * ()-> 10; //WRONG as Interface info not provided
 * <p>
 * POINTS: 1. A lambda expression does not have a name. 2. A lambda expression does not have a return type. It is
 * inferred by the compiler from the context of its use and from its body. 3. A lambda expression does not have a throws
 * clause. It is inferred from the context of its use and its body. 4. A lambda expression cannot declare type
 * parameters. That is, a lambda expression cannot be generics.
 */
@FunctionalInterface
interface F1 {
	void show();
}

@FunctionalInterface
interface F2 {
	int area(int x) throws ArithmeticException;
}

@FunctionalInterface
interface F3 {
	int calculate(int a, int b);
}

@FunctionalInterface
interface StringToIntMapper {
	int map(String str);
}

class LambdaTypes {
	static void f1lambda() {

		/**Overriding method from Interface F1
		 * from the code it is understood that RHS code returns a reference just like anonymous class
		 *
		 * the compiler sees the () and immediately knows we are taking about void show() of F1
		 * the -> directs that it is a Lambda Expression
		 * and the sout after it does what we tell it to. [NOTE show() has void return type so dont return anything]
		 */

		F1 f1 = () -> System.out.println("f1\tHello");
		f1.show();

		F1 f11 = () -> {
		};        //takes no parameter and returns void
		f11.show();

		F1 f12 = () -> {
			int x = 10;         //we can declare anything inside block { } just like any other function
			System.out.println("f12\t" + x);
		};
		f12.show();

	}

	static void f2Lambda() {
		/** In cases where we only have one function argument,
		 * we can choose to remove () from the argument on LHS
		 *
		 * if we have a return statement, two cases arise
		 * 1. explicitly writing statements
		 * { return 10; }
		 * 2. implicitly returning something(Expressions) that results in return type of method in interface
		 * x -> 10;
		 */

		F2 f2 = (int a) -> {
			return 10 * 5;
		};
		System.out.println("f2\t" + f2.area(5));

		//removes (int ) and {return --;}
		F2 f21 = a -> 10 * a;
		System.out.println("f21\t" + f21.area(5));

	}

	static void f3Lambda() {
		// Types of parameters are declared
		F3 f31 = (int x, int y) -> {
			return x + y;
		};

		// Types of parameters are omitted
		F3 f32 = (x, y) -> {
			return x + y;
		};
		/** If you omit the types of parameters, you must omit it for all parameters or for none.
		 * You cannot omit for some and not for others.
		 * (x, int y) ->{ ...} //will not compile
		 * The compiler will infer the types of parameters from the context in which the lambda expression is used.
		 */

		System.out.println("F3\t" + f31.calculate(5, 9));

		/**
		 * You can use modifiers, such as final, in the parameter declaration for explicit lambda expressions.
		 * The following two lambda expressions are valid:
		 (final int x, final int y) -> { return x + y; }
		 (int x, final int y) -> { return x + y; }

		 The following lambda expression will not compile because it uses the final modifier in parameter declarations,
		 but omits the parameter type:
		 (final x, final y) -> { return x + y; }
		 */
	}
}

public class LambdaWrittenTypes {

	public static void main(String[] args) {

		//NOTICE:
		StringToIntMapper mapper = (String str) -> str.length();
		/**
		 * In this statement, the compiler finds that the right-hand side of the assignment operator is a lambda
		 expression.
		 To infer its type, it looks at the left-hand side of the assignment operator that expects an instance of the
		 StringToIntMapper interface; it verifies that the lambda expression conforms to the declaration of the map() method
		 in the StringToIntMapper interface;
		 finally, it infers that the type of the lambda expression is the StringToIntMapper interface type.

		 When you call the map() method on the mapper variable passing a String, the body of the lambda
		 expression is executed as shown in the following snippet of code:
		 */
		System.out.println("mapper\t" + "MyStringOfLength18 - Size = " + mapper.map("MyStringOfLength18"));

		LambdaTypes.f1lambda();
		LambdaTypes.f2Lambda();
		LambdaTypes.f3Lambda();
	}
}

