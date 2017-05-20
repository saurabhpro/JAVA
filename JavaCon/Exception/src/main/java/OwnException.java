/**
 * Created by Saurabh on 9/25/2015.
 */
class MyException2 extends Exception {
	private int x;

	//default constructor
	public MyException2() {
		//implicitly calls super()
	}

	//string argument constructor
	public MyException2(String msg) {
		super(msg); //Exception class has these two constuctors only
	}

	//own own constructor type... still sending super(String)
	public MyException2(String msg, int x) {
		super(msg);
		this.x = x;
	}

	public int val() {
		return x;
	}

	@Override
	public String getMessage() {
		return "Detail Message: " + x + " " + super.getMessage();
	}
}

public class OwnException {
	public static void f() throws MyException2 {
		System.out.println("Throwing MyException2 from f()");
		throw new MyException2();
	}

	public static void g() throws MyException2 {
		System.out.println("Throwing MyException2 from g()");
		throw new MyException2("Originated in g()");
	}

	public static void h() throws MyException2 {
		System.out.println("Throwing MyException2 from h()");
		throw new MyException2("Originated in h()", 47);
	}

	public static void main(String[] args) {
		try {
			f();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
			/**the only difference between  e.printStackTrace(); and   e.printStackTrace(PrintStream);
			 * is that no argument printStackTrace() prints on System.err and not System.out
			 *
			 * The call stack shows the sequence of method calls that brought you to the point at
			 * which the exception was thrown.
			 */
		}
		try {
			g();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
		}
		try {
			h();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
			System.out.println("e.val() = " + e.val());
		}
	}
}

/* Output:
Throwing MyException2 from f()
MyException2: Detail Message: 0 null
	at OwnException.f(OwnException.java:36)
	at OwnException.main(OwnException.java:51)
Throwing MyException2 from g()
MyException2: Detail Message: 0 Originated in g()
	at OwnException.g(OwnException.java:41)
	at OwnException.main(OwnException.java:56)
Throwing MyException2 from h()
MyException2: Detail Message: 47 Originated in h()
	at OwnException.h(OwnException.java:46)
	at OwnException.main(OwnException.java:61)
e.val() = 47

Process finished with exit code 0

*///:~
