/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package clone;

/**
 * Created by Saurabh on 9/6/2015.
 */

class Temp1 {
	int g;

	Temp1(int g) {
		this.g = g;
	}
}


class ShallowClone implements Cloneable {
	private int x = 10;
	private final Temp1 t;

	@SuppressWarnings("SameParameterValue")
	private ShallowClone(int a) {
		t = new Temp1(a);
	}

	public static void main(String[] args) {
		ShallowClone c;
		ShallowClone m = new ShallowClone(100);

		System.out.println(m.t.g);
		System.out.println(m.x);

		c = m.clone();

		System.out.println(c.t.g);
		System.out.println(c.x);

		c.t.g = 300;        //since referring to same object, changes actual value
		c.x = 30;           //changes only its own object state

		System.out.println("M after Changes " + m.t.g);     //prints 300
		System.out.println("M after Changes " + m.x);

		if (m.t == c.t) {
			System.out.println("Shallow Copy Reference same!!!");
		}
	}

	//clone has protected access in Object class, so inheritance tree ke bahar se nhi call kar skte
	//clone returns Object
	@Override
	public ShallowClone clone() {
		try {
			return (ShallowClone) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
