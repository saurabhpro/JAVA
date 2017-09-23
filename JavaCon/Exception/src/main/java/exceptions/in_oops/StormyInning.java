/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
	Inning() throws BaseballException {
	}

	public void event() throws BaseballException {
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

	private StormyInning() throws RainedOut, BaseballException {
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
	public void rainHard() throws RainedOut {
	}

	// You can choose to not throw any exceptions,
	// even if the base version does:
	public void event() {
	}

	// Overridden methods can throw inherited exceptions:
	protected void atBat() throws PopFoul {
	}


} ///:~
