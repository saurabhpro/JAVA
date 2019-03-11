/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package udemy.util;

import java.math.BigInteger;

public class BigIntFact {

		public static BigInteger factorial(long n) {
			BigInteger tempResult = BigInteger.ONE;

			for (long i = n; i > 0; i--) {
				tempResult = tempResult.multiply(new BigInteger((Long.toString(i))));
			}

			return tempResult;
		}
	}