/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.overloading;/*
  Created by Saurabh on 8/30/2015.
 */

/**
 * Which overridden version of the method to call is decided at runtime based on the object type
 * but which overloaded version of the method to call is based on the reference type of the argument passed at compile time
 */
class Animal {
}

class Horse extends Animal {
}

public class CompileTimeOverloading {

	public static void main(String[] args) {
		CompileTimeOverloading cOb = new CompileTimeOverloading();
		Animal animal = new Animal();
		Horse horse = new Horse();

		cOb.doStuff(animal);
		cOb.doStuff(horse);
		//Expected output : In the animal Version
		//                  Inside the horse version

		Animal animal1 = new Horse();   //upcasting...
		// now if we pass the animal1 ref to doStuff konsa chelga>?
		/*
		  You might say the horse ref is passed so the horse version will be printed but its not
		  because the The actual object is a Horse but at runtime (after new ), the choice of which overloaded method
		  to call is not dynamically decided at runtime
		  The reference type - determined which overloaded version is invoked,
		  because compile time tk compiler know only about Animal type animal1
		 */
		cOb.doStuff(animal1);
	}

	private void doStuff(Animal m) {
		System.out.println("In the animal Version");
	}

	private void doStuff(Horse h) {
		System.out.println("Inside the horse version");
	}


}
