/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package udemy.util;

import java.math.BigInteger;
import java.util.logging.Logger;

public class BigIntPow {
	private static final Logger logger = Logger.getLogger(BigIntPow.class.getSimpleName());

	public static BigInteger pow(BigInteger base, BigInteger power) {

			BigInteger rv = base;

			for (BigInteger i = BigInteger.ONE; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {

				if (Thread.currentThread().isInterrupted()) {
					logger.warning(Thread.currentThread().getName() + " Interrupted forcefully");
					return BigInteger.ZERO;
				}

				rv = rv.multiply(base);
			}

			return rv;
		}
	}