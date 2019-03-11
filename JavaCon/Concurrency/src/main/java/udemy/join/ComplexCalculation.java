/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package udemy.join;

import udemy.util.BigIntPow;

import java.math.BigInteger;

public class ComplexCalculation {

	public static void main(String[] args) {
		System.out.printf("%s^%s + %s^%s = %s", 10000, 10000, 500, 500, new ComplexCalculation().calculateResult(BigInteger.valueOf(100000), BigInteger.valueOf(100000), BigInteger.valueOf(50000), BigInteger.valueOf(50000)));
	}

	public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
		BigInteger result;

        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
		PowerCalculatingThread t1 = new PowerCalculatingThread(base1, power1);
		PowerCalculatingThread t2 = new PowerCalculatingThread(base2, power2);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		result = t1.getResult().add(t2.getResult());

		return result;
	}

	private static class PowerCalculatingThread extends Thread {
		private BigInteger result = BigInteger.ZERO;
		private BigInteger base;
		private BigInteger power;

		public PowerCalculatingThread(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			this.result = BigIntPow.pow(base, power);
			// System.out.println(result);
		}

		public BigInteger getResult() {
			return result;
		}
	}
}