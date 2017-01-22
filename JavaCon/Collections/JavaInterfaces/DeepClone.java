/**
 * Created by Saurabh on 9/6/2015.
 */


class Temp2 implements Cloneable {
	int g;

	Temp2(int g) {
		this.g = g;
	}

	@Override
	public Temp2 clone() {
		try {
			return (Temp2) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}

public class DeepClone implements Cloneable {
	int x = 10;
	Temp2 t;

	DeepClone(int a) {
		t = new Temp2(a);
	}

	public static void main(String[] args) {
		DeepClone c = null;
		DeepClone m = new DeepClone(100);
		System.out.println(m.t.g);
		System.out.println(m.x);
		try {
			c = m.clone();
			//c.t  = m.t.clone()
		} catch (Exception e) {
		}

		assert c != null;       //own code

		System.out.println(c.t.g);
		System.out.println(c.x);

		c.t.g = 350;
		c.x = 35;

		System.out.println("M after changes " + m.t.g);
		System.out.println("M after changes " + m.x);

		if (m.t == c.t)
			System.out.println("My Deep Cloning");
	}

	@Override
	public DeepClone clone() {
		try {
			System.out.println("Inside Deep");
			DeepClone d1 = (DeepClone) super.clone();
			d1.t.clone();

			return d1;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
