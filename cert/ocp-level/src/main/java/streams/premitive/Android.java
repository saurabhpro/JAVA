package streams.premitive;

import java.util.function.Supplier;

public class Android {
	public static void main(String... electricSheep) {
		Android data = new Android();
		data.wakeUp(() -> "Program started!"); // d2
	}

	public void wakeUp(Supplier supplier) { // d1
		final Object o = supplier.get();
		System.out.println(o);
	}
}