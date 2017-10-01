/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package saurabh.Interface;

/**
 * Created by Saurabh on 9/2/2015.
 * Abstract classes are only used now when we want mutable instance variables,
 * other than that there is virtually no difference between abstract classes and interfaces from java 8
 */

@SuppressWarnings("All")
abstract class Animal {
	abstract void eat();

	abstract void speak();

	void sleep() {
		System.out.println("sleep");
	}

}

public class AbstractClassInstantiation {

	public static void main(String[] args) {
		new Animal() {
			@Override
			void eat() {

			}

			@Override
			void speak() {

			}
		};  //Anonymous class is created which is basically a subclass of abstract animal, which is legal
		//we are not creating instance of abstract class, any Anonymous class must be concrete
	}
}