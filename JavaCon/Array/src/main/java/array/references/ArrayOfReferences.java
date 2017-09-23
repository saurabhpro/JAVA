package array.references;

/**
 * Created by Saurabh on 9/1/2015.
 */

class A {
	private static int x;

	int increment() {
		return x++;
	}
}

class B extends A {
	@Override
	int increment() {
		return super.increment();
	}
}

class C extends B {
	private static int x = 5;

	@Override
	int increment() {
		return x++;
	}
}

public class ArrayOfReferences {
	public static void main(String[] args) {
		A[] array = new C[4];       //Allowed but this is where the type converted into array.references.A

		for (A iOb : array) {
			iOb = new C();
			System.out.println(iOb.increment() + " " + iOb.getClass());     //upcasting while creating iOb
		}
	}
}
