/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package parcel_TIJ;//: innerclasses/Parcel8.java
// Calling the base-class constructor.

//: innerclasses/Wrapping.java
class Wrapping {
	private final int i;

	public Wrapping(int x) {
		i = x;
	}

	public int value() {
		return i;
	}
} ///:~

public class Parcel8 {
	public static void main(String[] args) {
		Parcel8 p = new Parcel8();
		Wrapping w = p.wrapping(10);

		System.out.println(w.value());
	}

	private Wrapping wrapping(int x) {
		// Base constructor call:
		return new Wrapping(x) { // Pass constructor argument.
			public int value() {
				return super.value() * 47;
			}
		}; // Semicolon required
	}
} ///:~
