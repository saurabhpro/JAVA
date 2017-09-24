package basic;

import java.util.stream.IntStream;

//also see codingIntCh06
public class PrimeNumbers {

	static boolean primeNaive(int n) {
		return IntStream.range(2, n / 2).noneMatch(i -> n % i == 0);
	}

	static boolean primeSlightlyBetter(int n) {
		int sqrt = (int) Math.sqrt(n);
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
