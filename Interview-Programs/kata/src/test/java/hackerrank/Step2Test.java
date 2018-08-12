package hackerrank;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Step2Test {

    @Test
    void miniMaxSum() {
        int[] arr = new int[]{5, 7, 3, 9, 28, 9};

        Step2.miniMaxSum(arr);
    }

    @Test
    void miniMaxSum_largeSum() {
        int[] arr = new int[]{256741038, 623958417, 467905213, 714532089, 938071625};

        Step2.miniMaxSum(arr);
        // 2063136757 2744467344
    }

    @Test
    void birthdayCakeCandles() {
        int[] arr = new int[]{3, 1, 2, 3, 2, 3, 3};
        assertEquals(4, Step2.birthdayCakeCandles(arr));
    }


    @Test
    void timeConversion_basicPM() {
        String input = "07:05:45PM";
        String expected = "19:05:45";

        assertEquals(expected, Step2.timeConversion(input));

    }

    @Test
    void timeConversion_00() {
        String input = "12:05:45AM";
        String expected = "00:05:45";

        assertEquals(expected, Step2.timeConversion(input));
    }

    @Test
    void timeConversion_basicAM() {
        String input = "06:40:03AM";
        String expected = "06:40:03";

        assertEquals(expected, Step2.timeConversion(input));

    }

    @Test
    void findDigits() {
        assertEquals(3, Step2.findDigits(1012));
    }

    @Test
    void fact_basic5() {
        assertEquals(BigInteger.valueOf(120), Step2.fact(5, new HashMap<>()));
    }

    @Test
    void fact_long25() {
        assertEquals(new BigInteger("15511210043330985984000000", 10), Step2.fact(25, new HashMap<>()));
    }

    @Test
    void fact_big100() {
        assertEquals(new BigInteger("9332621544394415268169923885626670049071596826438162146859296389" +
                "5217599993229915608941463976156518286253697920827223758251185210" +
                "916864000000000000000000000000", 10), Step2.fact(100, new HashMap<>()));
    }

    @Test
    void appendAndDelete() {
        assertEquals("Yes", Step2.appendAndDelete("hackerhappy", "hackerrank", 9));
        assertEquals("No", Step2.appendAndDelete("ashley", "ash", 2));
        assertEquals("Yes", Step2.appendAndDelete("aba", "aba", 7));
    }

    @Test
    void gradingStudents() {
        int[] input = new int[]{73, 67, 38, 33};

        assertArrayEquals(new int[]{75, 67, 40, 33}, Step2.gradingStudents(input));
    }
}