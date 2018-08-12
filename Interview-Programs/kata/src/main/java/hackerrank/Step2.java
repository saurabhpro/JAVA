package hackerrank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

class Step2 {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        //IntStream stream = Arrays.stream(arr);    // the type of stream depends on type of array which is passed
        OptionalInt min = Arrays.stream(arr).min(); // Optional used as is arr is empty - it returns empty
        OptionalInt max = Arrays.stream(arr).max();


        long sum = 0;
        for (int ar : arr)
            sum += ar;

        System.out.println((sum - max.getAsInt()) + " " + (sum - min.getAsInt()));
    }

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        OptionalInt max = Arrays.stream(ar).max();

        int maxCandleCount = 0;
        for (int a : ar) {
            if (a == max.getAsInt()) ++maxCandleCount;
        }

        return maxCandleCount;
    }

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        int hourValue = Integer.parseInt(s.substring(0, 2));
        String timeOfDay = s.substring(s.length() - 2);
        String result;

        if ("PM".equals(timeOfDay) && hourValue < 12) {
            hourValue += 12;
            result = hourValue + s.substring(2, s.length() - 2);
        } else if ("AM".equals(timeOfDay) && hourValue == 12) {
            hourValue -= 12;
            result = "0" + hourValue + s.substring(2, s.length() - 2);
        } else {
            result = s.substring(0, s.length() - 2);
        }

        return result;
    }


    // Complete the findDigits function below.

    /**
     * method to check the digits in argument n for proper divisor
     *
     * @return number of digits (excpet 0) which are present in {@code n} and divides {@code n}
     */
    static int findDigits(int n) {
        int result = 0;
        int tmp = n;
        double digit = n % 10;

        while (tmp > 0) {
            if (digit != 0 && (n % digit) == 0)
                ++result;

            tmp /= 10;
            digit = tmp % 10;
        }

        return result;
    }

    // Complete the extraLongFactorials function below.
    private static void extraLongFactorials(int n) {
        BigInteger result = fact(n, new HashMap<>());
        System.out.println(result);
    }

    static BigInteger fact(int n, Map<Integer, BigInteger> ar) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        } else {

            if (!ar.containsKey(n)) {
                ar.put(n, fact(n - 1, ar).multiply(BigInteger.valueOf(n)));
            }

            return ar.get(n);
        }
    }

    // Complete the appendAndDelete function below. XX
    static String appendAndDelete(String s, String t, int k) {
        if (s.equals(t)) {
            if (k == 0) return "Yes";
            else if (k == (s.length() * 2) + 1) return "Yes";
            else return "No";
        }

        char[] st = s.toCharArray();
        char[] tr = t.toCharArray();

        int i = 0;
        while (i < st.length && i < tr.length && st[i] == tr[i]) {
            i++;
        }

        int changeInS = st.length - i;
        int changeInT = tr.length - i;

        return k == (changeInS + changeInT) ? "Yes" : "No";


    }

    static int[] gradingStudents(int[] grades) {
        int[] finalGrades = new int[grades.length];
        int gap;

        for (int i = 0; i < grades.length; i++) {
            gap = grades[i] % 5;

            if ((5 - gap) < 3 && grades[i] >= 38)
                finalGrades[i] = grades[i] + (5 - gap);
            else
                finalGrades[i] = grades[i];

        }
        return finalGrades;
    }

}
