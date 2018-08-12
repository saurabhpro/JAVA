package hackerrank;

import java.util.Arrays;

class Step1 {

    // Complete the staircase function below.
    static void staircase(int n) {

        for (int i = 1; i <= n; ++i) {
            for (int j = n - i; j > 0; --j) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; ++k) {
                System.out.print("#");
            }
            System.out.println();
        }
    }


    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double positive = 0;
        double negative = 0;

        for (int anArr : arr) {
            if (anArr > 0) ++positive;
            else if (anArr < 0) ++negative;
        }

        System.out.println(positive / arr.length);
        System.out.println(negative / arr.length);
        System.out.println((arr.length - (positive + negative)) / arr.length);
    }

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {
        int fDiag = 0;
        int bDiag = 0;

        for (int i = 0; i < arr.length; i++) {
            fDiag += arr[i][i];
            bDiag += arr[i][arr.length - i - 1];
        }

        return Math.abs(fDiag - bDiag);
    }

    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
        return Arrays.stream(ar).sum();
    }

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
        int arr[] = new int[a.length];

        for (int i = 0, j = a.length - 1; i < a.length; i++, j--)
            arr[i] = a[j];

        return arr;
    }
}
