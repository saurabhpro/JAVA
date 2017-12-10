package class_design.functionInterface;

@FunctionalInterface
interface LambdaFunction {
	void call();
}


public class FirstLambda {

	int gh = 99;

	LambdaFunction lambdaFunction1 = () -> {
		int g = 9;
		System.out.println("Hello world");
		// System.out.println(this.g); // error
		System.out.println(this.gh); //scope
	};

	public static void main(String[] args) {

		LambdaFunction lambdaFunction2 = new LambdaFunction() {
			int g = 9;

			@Override
			public void call() {
				System.out.println("Hello world");
				System.out.println(this.g);
			}
		};
		lambdaFunction2.call();

		// to

		LambdaFunction lambdaFunction1 = () -> {
			int g = 9;
			System.out.println("Hello world");
			//System.out.println(this.g); error
		};
		lambdaFunction1.call();

		// to

		LambdaFunction lambdaFunction = () -> System.out.println("Hello world");
		lambdaFunction.call();
        /*
- The lambda expression has () indicating it has no parameters—it matches with the call method that takes no parameters.
- The statement System.out.println("Hello world") is the body of the lambda expression. This body serves as an implementation of the lambda function.
- There is no return statement in this lambda expression body and hence the compiler infers the return type of this expression as void type—that matches with the return type of the call method.
         */
	}
}

/*
Lambda functions can refer to effective final local variables from the enclosing scope.

What happens if a lambda expression throws an exception?
If it is a checked exception, then the method in the functional interface should declare that;
otherwise it will result in a compiler error.
 */