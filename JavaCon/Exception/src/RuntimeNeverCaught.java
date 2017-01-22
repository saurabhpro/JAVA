//: exceptions/NeverCaught.java
// Ignoring RuntimeExceptions.
// {ThrowsException}

/**
 * RuntimeException (or anything inherited from it) is a special case,
 * since the compiler doesn�t require an exception specification for these types.
 * The output is reported to System.err:
 * <p>
 * You never need to write an exception specification saying that a method might
 * throw a RuntimeException (or any type inherited from RuntimeException),
 * because they are unchecked exceptions. [you cant do anything about it]
 * <p>
 * If a RuntimeException gets all the way out to main( ) without being caught,
 * printStackTrace( ) is called for that exception as the program exits.
 */
public class RuntimeNeverCaught {
	static void f() {
		throw new RuntimeException("From f()");
	}

	static void g() {
		f();
	}

	public static void main(String[] args) {
		g();
	}
} ///:~
