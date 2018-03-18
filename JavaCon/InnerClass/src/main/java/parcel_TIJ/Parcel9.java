/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package parcel_TIJ;//: innerclasses/Parcel9.java
// An anonymous inner class that performs
// initialization. A briefer version of Parcel5.java.

public class Parcel9 {
	public static void main(String[] args) {
		Parcel9 p = new Parcel9();
		Destination d = p.destination("Tasmania");
	}

	// Argument must be final to use inside
	// anonymous inner class:
	private Destination destination(final String dest) {
		return new Destination() {
			private final String label = dest;

			public String readLabel() {
				return label;
			}
		};
	}
} ///:~
