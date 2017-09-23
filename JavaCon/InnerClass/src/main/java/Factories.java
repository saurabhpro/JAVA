/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

//: innerclasses/Factories.java

interface Service {
	void method1();

	void method2();
}

@FunctionalInterface
interface ServiceFactory {
	Service getService();
}

@SuppressWarnings("ALL")
class Implementation1 implements Service {
	public static final ServiceFactory factory =
			new ServiceFactory() {
				public Service getService() {
					return new Implementation1();
				}
			};

	private Implementation1() {
	}

	public void method1() {
		System.out.println("Implementation1 method1");
	}

	public void method2() {
		System.out.println("Implementation1 method2");
	}
}

@SuppressWarnings("ALL")
class Implementation2 implements Service {
	public static final ServiceFactory factory =
			new ServiceFactory() {
				public Service getService() {
					return new Implementation2();
				}
			};

	private Implementation2() {
	}

	public void method1() {
		System.out.println("Implementation2 method1");
	}

	public void method2() {
		System.out.println("Implementation2 method2");
	}
}

public class Factories {
	private static void serviceConsumer(ServiceFactory fact) {
		Service s = fact.getService();
		s.method1();
		s.method2();
	}

	public static void main(String[] args) {
		serviceConsumer(Implementation1.factory);
		// Implementations are completely interchangeable:
		serviceConsumer(Implementation2.factory);
	}
} /* Output:
Implementation1 method1
Implementation1 method2
Implementation2 method1
Implementation2 method2
*///:~
