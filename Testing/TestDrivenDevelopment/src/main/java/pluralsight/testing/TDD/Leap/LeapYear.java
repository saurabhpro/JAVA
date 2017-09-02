package pluralsight.testing.TDD.Leap;

/**
 * Created by saurabhkumar on 21/05/17.
 * Example of TDD where this class was made on addition of test cases
 */
class LeapYear {
	static boolean isLeap(int year) {
		return isDivisible(year, 4) && (!isDivisible(year, 100) || isDivisible(year, 400));
	}

	private static boolean isDivisible(int value, int denominator) {
		return value % denominator == 0;
	}
}
