package class_design;

import java.io.Serializable;
import java.util.Collection;

public class Transport {
	public void convert() {
		Building b = new Building();
		House h = new House();
		Building bh = new House();
		Building p = b;
		// House q = (Building) h;
		Building r = bh;
		House s = (House) bh;

		House p1 = (House) b;
		House q1 = h;
		House r1 = (House) bh;

		// House c = (House) new Condo();

	}

	interface Vehicle {
	}

	public static void main(String[] args) {
		Bus bus = new Bus();
		Van[] vans = new Van[0];

		// boolean p = bus instanceof null; not possible

		System.out.println(null instanceof Bus);
		System.out.println(bus instanceof Vehicle);
		System.out.println(bus instanceof Bus);
		System.out.println(vans instanceof Van[]);
		System.out.println(vans instanceof Vehicle[]);
		// System.out.println(vans instanceof String[]);     inconvertible type

		// the compiler only knows that bus is not an ArrayList because ArrayList is a concrete class. it does not compile.
		// System.out.println(bus instanceof ArrayList);

		// The compiler can’t definitively state that bus is not a Collection. Some future program could create a subclass of Bus that does implement Collection, so this line compiles.
		System.out.println(bus instanceof Collection);
		// similarily ok
		System.out.println(bus instanceof Serializable);
	}

	class No1 extends No0 {
	}

	abstract class No0 {
	}

	static class Bus implements Vehicle {
	}

	static class Van extends Bus {
	}

	class Building {
	}

	class House extends Building {
	}

	class Condo {
	}
}