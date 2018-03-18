/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package functionalInterface;

/**
 * Created by Saurabh on 10/31/2015.
 */

@FunctionalInterface
interface Adder {
	double add(double n1, double n2);
}

@FunctionalInterface
interface Joiner {
	String join(String s1, String s2);
}

class LambdaUtil {
	void testAdder(Adder adder) {
		double x = 190.90;
		double y = 8.50;
		double sum = adder.add(x, y);
		System.out.print("Using an functionalInterface.Adder:");
		System.out.println(x + " + " + y + " = " + sum);
	}

	void testJoiner(Joiner joiner) {
		String s1 = "Hello";
		String s2 = "World";
		String s3 = joiner.join(s1, s2);
		System.out.print("Using a functionalInterface.Joiner:");
		System.out.println("\"" + s1 + "\" + \"" + s2 + "\" = \"" + s3 + "\"");
	}
}

public class LambdaAsArgument {
	public static void main(String[] args) {
		LambdaUtil util = new LambdaUtil();

		// Call the testAdder() method
		util.testAdder((x, y) -> x + y);

		// Call the testJoiner() method
		util.testJoiner((x, y) -> x + y);

		// Call the testJoiner() method. The functionalInterface.Joiner will
		// add a space between the two strings
		util.testJoiner((x, y) -> x + " " + y);


		// Call the testJoiner() method. The functionalInterface.Joiner will
		// reverse the strings and join resulting strings in
		// reverse order adding a comma in between
		util.testJoiner((x, y) -> {
			StringBuilder sbx = new StringBuilder(x);
			StringBuilder sby = new StringBuilder(y);
			sby.reverse().append(",").append(sbx.reverse());
			return sby.toString();
		});


		/*
		 * Notice the output of the functionalInterface.LambdaAsArgument class. The testJoiner() method was called three times, and every time
		 it printed a different result of joining the two strings �Hello� and �World�.

		 Using a functionalInterface.Joiner:"Hello" + "World" = "HelloWorld"
		 Using a functionalInterface.Joiner:"Hello" + "World" = "Hello World"
		 Using a functionalInterface.Joiner:"Hello" + "World" = "dlroW,olleH"

		 This is possible because different lambda
		 expressions were passed to this method. At this point,we have parameterized the behavior of the
		 testJoiner() method. That is, how the testJoiner() method behaves depends on its parameter.

		 Changing the behavior of a method through its parameters is known as behavior parameterization.
		 This is also known as passing code as data because you pass code (logic, functionality, or behavior)
		 encapsulated in lambda expressions to methods as if it is data.
		 */
	}
}

/*
 * IF METHOD ARGUMENTS ARE SAME IN TWO INTERFACES, sending a lambda as argument may cause ambiguity as type cant be
 * inffered from context The following are the some of the ways to help the compiler resolve the ambiguity:
 * <p>
 * 1. If the lambda expression is implicit, make it explicit by specifying the type of the parameters. 2. Use a cast. 3.
 * Do not use the lambda expression directly as the method argument. First, assign it to a variable of the desired type,
 * and then, pass the variable to the method.
 */