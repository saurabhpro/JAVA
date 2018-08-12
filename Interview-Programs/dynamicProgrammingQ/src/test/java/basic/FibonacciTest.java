package basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

    private static Fibonacci fibonacci;

    @BeforeAll
    static void setFibonacci() {
        fibonacci = new Fibonacci();
    }

    @Test
    void test_case1_gives1() {
        int expected = 1;

        Assertions.assertEquals(expected, fibonacci.getNthFibonacciNumber(1));
    }

    @Test
    void test_case0_gives1() {
        int expected = 1;

        Assertions.assertEquals(expected, fibonacci.getNthFibonacciNumber(0));
    }

    @Test
    void test_case2_gives1() {
        int expected = 1;

        Assertions.assertEquals(expected, fibonacci.getNthFibonacciNumber(2));
    }

    @Test
    void test_case9_gives34() {
        int expected = 34;

        Assertions.assertEquals(expected, fibonacci.getNthFibonacciNumber(9));
    }

    @Test
    void test_case21_gives10946() {
        int expected = 10946;

        Assertions.assertEquals(expected, fibonacci.getNthFibonacciNumber(21));
    }

    @Test
    void test_case41_gives165580141() {
        int expected = 165580141;

        Assertions.assertEquals(expected, fibonacci.getNthFibonacciNumber(41));
    }

    @Test
    void test_fast_case41_gives165580141() {
        int expected = 165580141;

        Assertions.assertEquals(expected, fibonacci.getNthFibonacciNumberFast(41));
    }

    @Test
    void test_faster_case41_gives165580141() {
        int expected = 165580141;

        Assertions.assertEquals(expected, fibonacci.fib(41));
    }
}
