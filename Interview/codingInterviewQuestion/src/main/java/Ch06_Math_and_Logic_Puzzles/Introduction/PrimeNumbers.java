package Ch06_Math_and_Logic_Puzzles.Introduction;

import java.util.stream.IntStream;

public class PrimeNumbers {

	public static boolean primeNaive(int n) {
		return IntStream.range(2, n / 2).noneMatch(i -> n % i == 0);
	}

	private static boolean primeSlightlyBetter(int n) {
		int sqrt = (int) Math.sqrt(n);
		/*
		for (int i = 2; i <= sqrt; i++) {

			if (n % i == 0) {
				return false;
			}
		}
		return true;
		*/

		return IntStream.rangeClosed(2, sqrt).noneMatch(i -> n % i == 0);
	}

	public static void main(String[] args) {
		for (int i = 2; i < 100; i++) {
			if (primeSlightlyBetter(i)) {
				System.out.println(i);
			}
		}
	}

}
