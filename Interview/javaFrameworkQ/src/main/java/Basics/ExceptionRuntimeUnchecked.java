package Basics;

class EX22 extends RuntimeException {
}

class EX11 extends Throwable {

}

public class ExceptionRuntimeUnchecked {

	public static void main(String[] args) {
		ExceptionRuntimeUnchecked ex = new ExceptionRuntimeUnchecked();
		int res = ex.show2();


	}

	private int show() throws EX22 {

		throw new EX22();       // Runtime exceptions are unchecked

		// no return element

	}

	private int show2() throws EX22 {

		return show();
	}
}


/*
 Exception in thread "main" Basics.EX22
 at javaFrameworkQ/Basics.ExceptionRuntimeUnchecked.show(ExceptionRuntimeUnchecked.java:10)
 at javaFrameworkQ/Basics.ExceptionRuntimeUnchecked.show2(ExceptionRuntimeUnchecked.java:16)
 at javaFrameworkQ/Basics.ExceptionRuntimeUnchecked.main(ExceptionRuntimeUnchecked.java:21)

What design pattern is used to implement Exception handling Features in most languages?
This is an example of Chain of Responsibility Pattern defined as “a way of passing a request between a chain of objects”.

A good real time example is the Loan or Leave Approval Process. When a loan approval is needed,
it first goes to the clerk. If he cannot handle it (large amount), it goes to his manager and so on
until it is approved or rejected.
*/