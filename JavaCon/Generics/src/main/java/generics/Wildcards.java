/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saurabh on 8/13/2015.
 */

/* <?> is the one most important wildcards which is used to extends, super */
// Collection<?> (pronounced "collection of unknown")
    /*
    List<?>           listUknown = new ArrayList<A>();
    List<? extends A> listUknown = new ArrayList<A>();
    List<? super   A> listUknown = new ArrayList<A>();
     */

public class Wildcards {
	private static void unknownType() {
		System.out.println("List<?> means a list typed to an unknown type. This could be a List<A>, " +
				"a List<B>, a List<String> etc.\n");

		List<?> elements;
		//noinspection UnusedAssignment
		elements = new ArrayList<A>();
		//noinspection UnusedAssignment
		elements = new ArrayList<>();      //new expressions with typed arguments can be replaced with <>
		//noinspection UnusedAssignment
		elements = new ArrayList<String>();
		//noinspection UnusedAssignment
		elements = new ArrayList<D>();
		//noinspection UnusedAssignment
		elements = new ArrayList<Serializable>();

		//System.out.println(elements);
	}

	private static void extendsBoundaryType() {
		System.out.println("List<? extends A> means a List of objects that are instances of the class A, " +
				"or subclasses of A (e.g. B and C).\n");

		List<? extends A> elements;
		//elements = new ArrayList<String>();       Not allowed as String is not subclass of A
		//elements = new ArrayList<Object>();       Not Allowed
		//noinspection UnusedAssignment
		elements = new ArrayList<B>();
		//noinspection UnusedAssignment
		elements = new ArrayList<D>();
		//elements.add(@Flow Capture of ? extends A e)  ; ??

		//noinspection UnusedAssignment
		elements = new ArrayList<>();            //didnt't we just see <> means <Object> and <Object> was not acceptable!!!

		//System.out.println(elements);

	}

	private static void superBoundaryType() {
		System.out.println("List<? super D> means that the list is typed to either the D class, or a superclass of D.");

		List<? super D> elements;
		//noinspection UnusedAssignment
		elements = new ArrayList<A>();
		//noinspection UnusedAssignment
		elements = new ArrayList<Object>();
		// elements = new ArrayList<C>();        //C is not in super class Herirachy of class D

		//System.out.println(elements);

	}

	public static void main(String[] args) {
		unknownType();
		extendsBoundaryType();
		superBoundaryType();

	}

	class A {
	}

	class B extends A {
	}

	private class C extends A {
	}

	private class D extends B {
	}
}

