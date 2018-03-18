/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package parcel_TIJ;//: innerclasses/Parcel7b.java
// Expanded version of Parcel7.java

public class Parcel7b {
	public static void main(String[] args) {
		Parcel7b p = new Parcel7b();
		Contents c = p.contents();
	}

	private Contents contents() {
		return new MyContents();
	}

	class MyContents implements Contents {
		private final int i = 11;

		public int value() {
			return i;
		}
	}
} ///:~
