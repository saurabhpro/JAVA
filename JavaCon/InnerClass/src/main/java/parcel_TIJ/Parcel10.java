/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package parcel_TIJ;//: innerclasses/Parcel10.java
// Using "instance initialization" to perform
// construction on an anonymous inner class.

public class Parcel10 {
	public static void main(String[] args) {
		Parcel10 p = new Parcel10();
		Destination d = p.destination("Tasmania", 101.395F);
	}

	private Destination
	destination(final String dest, final float price) {
		return new Destination() {
			private int cost;
			private final String label = dest;

			// Instance initialization for each object:
			{
				cost = Math.round(price);
				if (cost > 100)
					System.out.println("Over budget!");
			}

			public String readLabel() {
				return label;
			}
		};
	}
} /* Output:
Over budget!
*///:~
