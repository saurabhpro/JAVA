/**
 * Created by Saurabh on 8/31/2015.
 */

class Egg {
	private Yolk y = new Yolk();

	Egg() {
		System.out.println("new Egg()");
	}

	void insertYolk(Yolk yk) {
		y = yk;
	}

	void g() {
		y.f();
	}

	class Yolk {
		public Yolk() {
			System.out.println("Egg.Yolk()");
		}

		public void f() {
			System.out.println("Egg.Yolk.f()");
		}

	}
}

public class BigEggOverriddenInner extends Egg {

	private BigEggOverriddenInner() {
		insertYolk(new Yolk());
	}

	public static void main(String[] args) {
		Egg e = new BigEggOverriddenInner();
		e.g();
	}

	public class Yolk extends Egg.Yolk {

		Yolk() {
			System.out.println("BigEggOverriddenInner.Yolk()");
		}

		public void f() {
			System.out.println("BigEggOverriddenInner.Yolk.f()");
		}   //override Egg.Yolk.f();
	}

}

/*
Egg.Yolk()
new Egg()
Egg.Yolk()
BigEggOverriddenInner.Yolk()
BigEggOverriddenInner.Yolk.f()
 */