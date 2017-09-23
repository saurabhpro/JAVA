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
 * Created by Saurabh on 8/14/2015.
 */

/*
Java has covariant return types, so if you want to provide a more strongly typed
implementation than the interface specifies, that's okay. For instance, this is fine:

Covariant return types circa jdk 1.5
changes its return type to subclass type [return types has to be non-primitive] eg. Foo3, Foo4
 */
@FunctionalInterface
interface Foo {
	@SuppressWarnings("unused")
	Object getBar();        //Object
}

@FunctionalInterface
interface Foo2 {
	@SuppressWarnings("unused")
	String getBar();
}


@FunctionalInterface
interface Foo3 {
	@SuppressWarnings({"SameReturnValue", "unused"})
	Number getBar();
}


@FunctionalInterface
interface Foo4 {
	@SuppressWarnings({"SameReturnValue", "unused"})
	Integer getBar();
}

//if both interfaces implemented simultaneously
// case 1 : one of two is Object type, strict wala chlega eg. class T1
// case 2: both strict - Error ayega! eg class T2
@SuppressWarnings("ALL")
class T1 implements Foo, Foo2 {
	@Override
	public String getBar() {
		return "Hi";
	}
}

/**
 * So Basically we can have Foo as the third interface since it has method return type as Object
 * but using Foo2 - will give error
 */
@SuppressWarnings("unused")
class T2 implements Foo3, Foo4 {
	@Override
	public Integer getBar() {
		return null;
	}

}

class Test implements Foo, Foo2 {
	//Any Class return type works with Object
	public String getBar() {
		return "hi";
	}
	//public Integer getBar()    {        return 5;    }

	//public T1 getBar() {        return new T1();    }

}


@SuppressWarnings("All")
public class CovariantReturnType {
	private static final Test t = new Test();

	public static void main(String[] args) {
		System.out.println(t.getBar());
	}

}
