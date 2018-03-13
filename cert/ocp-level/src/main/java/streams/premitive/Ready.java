package streams.premitive;

import java.util.function.Supplier;

public class Ready {
	private static double getNumber() {
		return .007;
	}

	public static void math() {
		Supplier<Double> s = Ready::getNumber;
		double d = s.get();
		System.out.println(d);
	}

	public static void main(String[] args) {
		math();
	}
}