package basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimeNumbersTest {
    @Test
    void primeNaiveWith17() {
        Assertions.assertEquals(true, PrimeNumbers.primeNaive(17));
    }

    @Test
    void primeSlightlyBetterWith17() {
        Assertions.assertEquals(true, PrimeNumbers.primeSlightlyBetter(17));
    }


    @Test
    void primeNaiveWith1837() {
        Assertions.assertEquals(true, PrimeNumbers.primeNaive(18371));
    }

    @Test
    void primeSlightlyBetterWith1837() {
        Assertions.assertEquals(true, PrimeNumbers.primeSlightlyBetter(18371));
    }

    @Test
    void primeNaiveWith1972133() {
        Assertions.assertEquals(true, PrimeNumbers.primeNaive(1972133));
    }

    @Test
    void primeSlightlyBetterWith1972133() {
        Assertions.assertEquals(true, PrimeNumbers.primeSlightlyBetter(1972133));
    }

    @Test
    void primeNaiveWith60() {
        Assertions.assertEquals(false, PrimeNumbers.primeNaive(60));
    }

    @Test
    void primeSlightlyBetterWith60() {
        Assertions.assertEquals(false, PrimeNumbers.primeSlightlyBetter(60));
    }
}