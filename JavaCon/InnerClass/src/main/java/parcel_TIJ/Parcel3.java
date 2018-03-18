/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package parcel_TIJ;//: innerclasses/Parcel3.java
// Using .new to create instances of inner classes.

public class Parcel3 {
	public static void main(String[] args) {
		Parcel3 p = new Parcel3();
		// Must use instance of outer class
		// to create an instance of the inner class:
		Contents c = p.new Contents();
		Destination d = p.new Destination("Tasmania");
	}

	class Contents {
		private final int i = 11;

		public int value() {
			return i;
		}
	}

	class Destination {
		private final String label;

		Destination(String whereTo) {
			label = whereTo;
		}

		String readLabel() {
			return label;
		}
	}
} ///:~
