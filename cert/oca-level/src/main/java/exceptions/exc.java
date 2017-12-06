package exceptions;

import javax.management.BadStringOperationException;
import java.io.IOException;
import java.util.ConcurrentModificationException;

public class exc {
	public static void main(String[] args) throws IOException {
		new exc().show();
	}

	void show() throws IOException {
		try {
			throw new NullPointerException(); //runtime exception handled
		} catch (NullPointerException ignored) {
			System.out.println("HeyMark");
			it();
		}
	}

	void it() throws IOException {
		throw new IOException();
	}

	void i9() {
		throw new ArrayIndexOutOfBoundsException();
	}

	void i8() {
		throw new ClassCastException();
	}

	void i80() {
		throw new NumberFormatException();
	}

	void i7() {
		throw new ArithmeticException();
	}

	void i6() {
		throw new IllegalArgumentException();
	}

	void i5() {
		throw new IllegalStateException();
	}

	void i4() throws BadStringOperationException {
		throw new BadStringOperationException("Wrong");    // checked
	}

	void i3() {
		throw new ConcurrentModificationException();
	}

	void i2() {
		throw new UnsupportedOperationException();
	}

	void i1() throws ClassNotFoundException {
		throw new ClassNotFoundException(); // checked
	}

	void i0() throws Throwable {
		throw new Throwable();  // Checked
		// Checked exceptions include any exceptions, except for RuntimeException, and its subclasses.
	}

	void e9() {
		throw new StackOverflowError();
	}
}

class Next extends exc {
	public static void main(String[] args) {
		exc ob = new Next();

		Next op = (Next) ob;
		//((Next) op).it();

		try {
			new Next().go();
		} catch (StackOverflowError er) {
			System.out.println("ouch");
		}

		String s1 = "Hello ";
		String s2 = s1 + "World";
		s1.concat("fall");
		s2.concat(s1);
		s1 += "winter";

		// A total of eight String objects were created as follows: "spring ", "summer " (lost), "spring summer ",
		// "fall " (lost), "spring fall " (lost), "spring summer spring " (lost), "winter " (lost),
		// "spring winter " (at this point "spring " is lost). Only two of the eight String objects are not lost in this process.

		System.out.println(s1 + " " + s2);

		StringBuilder sb = new StringBuilder("0123456789");
		System.out.println(sb.delete(3, 4));

		Integer i1 = 1000;
		Integer i2 = 1000;
		System.out.println(i1 == i2);     // false  >127

		Integer i3 = 10;
		Integer i4 = 10;
		System.out.println(i3 == i4);     // true <127

		System.out.println(++i3); // how can we increment Object Integer ? 3 steps unbox raise box

		try {
			t3();
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
		}
	}

	private static void t3() throws RuntimeException {
		//		System.out.print("a");
//		try {
//			System.out.print("b");
//			throw new IllegalArgumentException();
//		} catch (IllegalArgumentException e) {
//			System.out.print("c");
//			throw new RuntimeException("1");
//		} catch (RuntimeException e) {
//			System.out.print("d");
//			throw new RuntimeException("2");
//		} finally {
//			System.out.print("e");
//			throw new RuntimeException("3");
//		}

		System.out.print("a");
		try {
			System.out.print("b");
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			System.out.print("c");
			//throw new NullPointerException();   // not even this can be handled without it own try catch
			String s = null;
			s.length(); // not even this can be handled without it own try catch
			throw new IllegalArgumentException("1");    // not handled :O
		} catch (RuntimeException e) {
			System.out.print("d");
			throw new RuntimeException("2");
		} finally {
			System.out.print("e");
			throw new RuntimeException("3");
		}
	}

	void go() {
		go();
	}
}