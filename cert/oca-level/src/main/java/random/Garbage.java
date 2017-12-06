package random;

import java.util.Date;

public class Garbage {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();

		System.out.println(rt.totalMemory());
		System.out.println(rt.freeMemory());

		for (int i = 0; i < 100000; i++) {
			Date d = new Date();
			d = null;
		}


		System.out.println(rt.freeMemory());
		rt.gc();    // or System.gc()
		System.out.println(rt.freeMemory());


		int x1 = 0b111_000;
		int x2 = 0x111_000;
	}
}


class Fizz {
	static int i = 9;

	public static void main(String[] args) {
		final Fizz f1 = new Fizz();
		Fizz f2 = new Fizz();
		Fizz f3 = fizzSwap(f1, f2);


		System.out.println((f1 == f3) + " " + (f1.i == f3.i));
	}

	private static Fizz fizzSwap(Fizz f1, Fizz f2) {
		final Fizz f3 = f1;
		f3.i = 8;

		return f3;
	}
}