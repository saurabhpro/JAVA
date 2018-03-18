/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package exceptions.in_oops;//: exceptions/exceptions.in_oops.StormyInning.java
// Overridden methods may throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions.

interface Storm {
	void event() throws RainedOut;

	void rainHard() throws RainedOut;
}

class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {
	Inning() {
	}

	public void event() {
		// Doesn't actually have to throw anything
	}

	protected abstract void atBat() throws Strike, Foul;

	public void walk() {
	} // Throws no checked exceptions
}

class StormException extends Exception {
}

class RainedOut extends StormException {
}

class PopFoul extends Foul {
}

public class StormyInning extends Inning implements Storm {
	// OK to add new exceptions for constructors, but you
	// must deal with the base constructor exceptions:

	private StormyInning() throws BaseballException {
	}

	public StormyInning(String s) throws BaseballException {
	}

	public static void main(String[] args) {
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		} catch (PopFoul e) {
			System.out.println("Pop foul");
		} catch (RainedOut e) {
			System.out.println("Rained out");
		} catch (BaseballException e) {
			System.out.println("Generic baseball exception");
		}
		// exceptions.in_oops.Strike not thrown in derived version.
		try {
			// What happens if you upcast?
			Inning i = new StormyInning();
			i.atBat();
			// You must catch the exceptions from the
			// base-class version of the method:
		} catch (Strike e) {
			System.out.println("exceptions.in_oops.Strike");
		} catch (Foul e) {
			System.out.println("exceptions.in_oops.Foul");
		} catch (RainedOut e) {
			System.out.println("Rained out");
		} catch (BaseballException e) {
			System.out.println("Generic baseball exception");
		}
	}

	// Regular methods must conform to base class:
	//! void walk() throws exceptions.in_oops.PopFoul {} //Compile error
	// Interface CANNOT add exceptions to existing
	// methods from the base class:
//! public void event() throws exceptions.in_oops.RainedOut {}
	// If the method doesn't already exist in the
	// base class, the exception is OK:
	public void rainHard() {
	}

	// You can choose to not throw any exceptions,
	// even if the base version does:
	public void event() {
	}

	// Overridden methods can throw inherited exceptions:
	protected void atBat() {
	}


} ///:~
