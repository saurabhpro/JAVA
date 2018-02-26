package sybex.ch04;

import java.util.Optional;

public class option {
	public static void main(String[] args) throws Throwable {

		String value = null;
		Optional o = (value == null) ? Optional.empty() : Optional.of(value);

		System.out.println(o);

		value = "sk";
		o = Optional.ofNullable(value);
		System.out.println(o);

		System.out.println(o.orElseThrow(RuntimeException::new));


		Optional<Double> opt = average(90, 100);
		opt.ifPresent(System.out::println);

		opt = average();
		System.out.println(opt.orElse(Double.NaN));
		System.out.println(opt.orElseGet(() -> Math.random()));
		System.out.println(opt.orElseThrow(() -> new IllegalStateException()));
	}

	private static Optional<Double> average(int... scores) {
		if (scores.length == 0) return Optional.empty();
		int sum = 0;
		for (int score : scores) sum += score;
		return Optional.of((double) sum / scores.length);
	}
}

/*
 * Optional.empty
 * Optional[sk]
 * */