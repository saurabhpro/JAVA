/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.saurabh.special;

/*
  Created by Saurabh on 8/30/2015.
 */

/**
 * C#
 * Private Constructor - This is the constructor whose access modifier is
 * private. private constructor is used to prevent a class to be
 * instantiated. But, if a class has other public constructors, then that
 * can be instantiated. A class can have multiple private constructor and can call it by another constructor.
 * For example:-
 * Class A
 * {
 * ����� int a;
 * ����� private A()�����{}
 * ������ public A(int b) : A()� // Calling private constructor by another constructor.
 * ������ {
 * ��������������� this.a=b;
 * ������� }
 * }
 * <p>
 * <p>
 * Static Constructor :- Static constructor is used to initialize static members
 * of a class. It is called by CLR, not by creating instance of the class.
 * As it is called by CLR, it is not certain when it is called. But it is
 * called when class is loaded. It can not be explicitly called by code.
 * Static constructor has no any parameter. A class can have only one static constructor.
 */
public class StaticConstructors {

	public static void main(String[] args) {
		System.out.println("A constructor can not be static in Java." + "\nIt's actually pretty simple to understand \n" +
				"- Everything that is marked static belongs to the class only, \n" +
				"for example static method cannot be inherited in the sub class because they belong to the class in which they have been declared.\n" +
				"Refer static keyword.\n\n" +
				"Lets back to constructors, " +
				"Since each constructor is being called by its subclass during a_creation of the object of its subclass,\n" +
				"so if you mark constructor as static the subclass will not be able to access the constructor of its parent class\n " +
				"thus object of child class couldn't be created.\n" +
				"because it is marked static and thus belong to the class only.\n" +
				"This will violate the whole purpose of inheritance concept and that is reason why a constructor cannot be static.\n\n" +
				"Static Constructor Alternative - Static Blocks in java");
	}
}