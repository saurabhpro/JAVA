/*
 * Copyright (c) 2019 Saurabh Kumar
 */

package udemy.join;

import org.junit.jupiter.api.Test;
import udemy.util.BigIntPow;

import java.math.BigInteger;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

class ComplexCalculationTest {

	@Test
	void calculateResultAsync() {

		//The following assertion succeeds.
		assertTimeout(Duration.ofSeconds(6), () -> {
			new ComplexCalculation().calculateResult(BigInteger.valueOf(100000), BigInteger.valueOf(100000),
					BigInteger.valueOf(500000), BigInteger.valueOf(50000));
		});
	}

	@Test
	void calculateResultSync(){

		assertTimeout(Duration.ofSeconds(8), () -> {
			BigIntPow.pow(BigInteger.valueOf(100000), BigInteger.valueOf(100000)).add(
					BigIntPow.pow(BigInteger.valueOf(500000), BigInteger.valueOf(50000)));
		});
	}
}