package hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Step1Test {

    @Test
    void staircase() {
        Step1.staircase(6);
    }

    @Test
    void plusMinus() {
        int[] arr = new int[]{-4, 3, -9, 0, 4, 1};

        Step1.plusMinus(arr);
    }

    @Test
    void diagonalDifference() {
        int[][] arr = new int[][]{
                new int[]{11, 2, 4},
                new int[]{4, 5, 6},
                new int[]{10, 8, -12}
        };
        assertEquals(15, Step1.diagonalDifference(arr));
    }

    @Test
    void aVeryBigSum() {
        long[] arr = new long[]{256741038, 623958417, 467905213, 714532089, 938071625};
        assertEquals(3001208382L, Step1.aVeryBigSum(arr));

        arr = new long[]{1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
        assertEquals(5000000015L, Step1.aVeryBigSum(arr));
    }

    @Test
    void reverseArray() {
        int[] ar = new int[]{1, 2, 3, 4};
        assertArrayEquals(new int[]{4, 3, 2, 1}, Step1.reverseArray(ar));
    }
}