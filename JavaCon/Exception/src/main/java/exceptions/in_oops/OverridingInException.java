/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package exceptions.in_oops;

import java.util.ConcurrentModificationException;

interface Albus {
	void snapeKill() throws Harry;

	void wandMagic() throws Harry;
}

/**
 * Created by Saurabh on 9/2/2015.
 */
class Marry extends Exception {
}

class Harry extends Marry {
}

class Animal extends ArithmeticException {
	public void eat() throws Exception {
	}

	public void sleep() throws Animal {
	}

	public void wandMagic() throws Animal {
		System.out.println("Inside wand magic!!!");
	}
}

class Dog extends Animal implements Albus {
	/**
	 * Overriding functions mustn't throw checked exceptions that are new or broader
	 * than those declared by the overridden method of base class
	 * <p>
	 * Overriding functions can however throw narrower or fewer exceptions or even no exception.
	 * "just because base class method takes risk, doesn't mean overriding method takes the same risk
	 */
	@Override   //valid for an subclass overriding method to not throw an error
	public void eat() {
		System.out.println("Inside exceptions.in_oops.Child No Exception");
	}

	// public void eat() throws Throwable{ } // this is not valid as Throwable > Exception

	/**
	 * throwing an exceptions.in_oops.Animal that is subclass of ArithmeticException in base class, now throwing NumberFormatException
	 * that also inherits from same ArithmeticException, so equal breadth of both Exception
	 */
	@Override
	public void sleep() throws NumberFormatException {
	}//or no exception also valid

	@Override
	public void snapeKill() throws Harry {
	}
}

class OverridingInException extends Animal {
	public static void main(String[] args) throws Harry {
		Albus albus = new Dog();
		albus.wandMagic();
	}

	//valid as Exception > ConcurrentME
	@Override
	public void eat() throws ConcurrentModificationException {
	}

    /* Not a legal overload
    public String eat(){
        return null;
    }
    */

	@Override
	public void sleep() throws Dog {
	}
	//This is perfectly valid!
	//as overloaded methods are new and not overriding anything

	//Overloaded function
	public void eat(int g) throws Throwable {
	}
}
