package basic;

public class Fibonacci {
    private int[] ar = new int[100];

    public int getNthFibonacciNumber(int num) {

        prevalidate(num);
        if (num == 0) {
            return num;
        } else if (num <= 2) {
            return 1;
        } else {
            return getNthFibonacciNumber(num - 1) + getNthFibonacciNumber(num - 2);
        }
    }

    private void prevalidate(int num) throws IllegalArgumentException {
        if (num < 0)
            throw new IllegalArgumentException("Negative numbers can't be calculated!");
    }

    public int getNthFibonacciNumberFast(int num) {
        if (num == 0) {
            ar[0] = 0;
            return num;
        } else if (num <= 2) {
            if (ar[num] == 0) {
                ar[1] = ar[2] = 1;
            }
            return ar[num];
        } else {
            int rs;
            if (ar[num] != 0)
                rs = ar[num];
            else {
                rs = getNthFibonacciNumber(num - 1) + getNthFibonacciNumber(num - 2);
            }
            ar[num] = rs;

            return rs;
        }
    }

    int fib(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n + 1];
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
       /* Add the previous 2 numbers in the series
         and store it */
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

}
