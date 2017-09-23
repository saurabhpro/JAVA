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

class Egg {
	private Yolk y = new Yolk();

	Egg() {
		System.out.println("new Egg()");
	}

	void insertYolk(Yolk yk) {
		y = yk;
	}

	void g() {
		y.f();
	}

	class Yolk {
		public Yolk() {
			System.out.println("Egg.Yolk()");
		}

		public void f() {
			System.out.println("Egg.Yolk.f()");
		}

	}
}

public class BigEggOverriddenInner extends Egg {

	private BigEggOverriddenInner() {
		insertYolk(new Yolk());
	}

	public static void main(String[] args) {
		Egg e = new BigEggOverriddenInner();
		e.g();
	}

	public class Yolk extends Egg.Yolk {

		Yolk() {
			System.out.println("BigEggOverriddenInner.Yolk()");
		}

		public void f() {
			System.out.println("BigEggOverriddenInner.Yolk.f()");
		}   //override Egg.Yolk.f();
	}

}

/*
Egg.Yolk()
new Egg()
Egg.Yolk()
BigEggOverriddenInner.Yolk()
BigEggOverriddenInner.Yolk.f()
 */