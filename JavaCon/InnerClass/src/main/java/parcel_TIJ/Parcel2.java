/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package parcel_TIJ;//: innerclasses/Parcel2.java
// Returning a reference to an inner class.

public class Parcel2 {
	public static void main(String[] args) {
		Parcel2 p = new Parcel2();
		p.ship("Tasmania");
		Parcel2 q = new Parcel2();
		// Defining references to inner classes:
		Contents c = q.contents();
		Destination d = q.to("Borneo");
	}

	private Destination to(String s) {
		return new Destination(s);
	}

	private Contents contents() {
		return new Contents();
	}

	private void ship(String dest) {
		Contents c = contents();
		Destination d = to(dest);
		System.out.println(d.readLabel());
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
} /* Output:
Tasmania
*///:~
