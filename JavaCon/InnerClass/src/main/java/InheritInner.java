/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

/**
 * Created by Saurabh on 8/31/2015.
 */

class WithinInner {
	class Inner {
		Inner() {
			System.out.println("Inside Inner constructor via super of InheritInner!");
		}
	}
}

/**
 * only writing WithinInner.Inner says : No enclosing instance of type WithinInner in this class :)
 */
public class InheritInner extends WithinInner.Inner {
	//so this  default constructor wont work, Not an error but program wont compile
	//InheritInner(){ }         //has to be commented out
	// Error:(14, 21) java: an enclosing instance that contains WithinInner.Inner is required

	private InheritInner(WithinInner wi) {

		//enclosingClassReference.super();
		wi.super();
	}

	public static void main(String[] args) {
		WithinInner wi = new WithinInner();

		//sending the instance of type WithinInner via InheritInner Constructor
		InheritInner ii = new InheritInner(wi);
	}
	//class Inner{} or this

	/**
	 * having class with same name as base class don't do anything
	 */
	private class Inner extends WithinInner.Inner {
		Inner(WithinInner wi) {
			//enclosingClassReference.super();
			wi.super();
		}
	}


}
