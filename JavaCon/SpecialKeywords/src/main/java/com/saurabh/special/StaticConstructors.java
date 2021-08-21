/*
 * Copyright (c) 2018 Saurabh Kumar
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
        final String x = """
                		A constructor can not be static in Java.
                		It's actually pretty simple to understand
                		- Everything that is marked static belongs to the class only,
                		for example static method cannot be inherited in the sub class because they belong to the class in which they have been declared.
                		Refer static keyword.
                		
                		Lets back to constructors,
                		Since each constructor is being called by its subclass during a_creation of the object of its subclass,
                		so if you mark constructor as static the subclass will not be able to access the constructor of its parent class
                		thus object of child class couldn't be created.
                		because it is marked static and thus belong to the class only.
                		This will violate the whole purpose of inheritance concept and that is reason why a constructor cannot be static.
                		
                		Static Constructor Alternative - Static Blocks in java")
                        """;

        System.out.println(x);
    }
}