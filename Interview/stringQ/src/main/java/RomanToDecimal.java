/**
 * Created by saurabhkumar on 23/07/17.
 */
public class RomanToDecimal {

	// This function returns integerValueForRomanCharacter of a Roman symbol
	static int integerValueForRomanCharacter(char r) {
		if (r == 'I')
			return 1;
		if (r == 'V')
			return 5;
		if (r == 'X')
			return 10;
		if (r == 'L')
			return 50;
		if (r == 'C')
			return 100;
		if (r == 'D')
			return 500;
		if (r == 'M')
			return 1000;
		return -1;
	}

	/**
	 * using RegEx to check for validity of Roman numbers
	 * Read: https://stackoverflow.com/a/267405/4853910
	 */
	static boolean validateRomanNumber(String num) {
		String pattern = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

		return num.matches(pattern);
	}

	// Finds decimal integerValueForRomanCharacter of a given roman numeral
	static int romanToDecimal(String str) {
		// Initialize result
		int result = 0;

		for (int i = 0; i < str.length(); i++) {
			// Getting integerValueForRomanCharacter of symbol s[i]
			int s1 = integerValueForRomanCharacter(str.charAt(i));

			// Getting integerValueForRomanCharacter of symbol s[i+1]
			if (i + 1 < str.length()) {
				int s2 = integerValueForRomanCharacter(str.charAt(i + 1));

				// Comparing both values
				if (s1 >= s2) {
					// Value of current symbol is greater
					// or equalto the next symbol
					result = result + s1;
				} else {
					result = result + s2 - s1;
					i++; // Value of current symbol is
					// less than the next symbol
				}
			} else {
				result = result + s1;
				i++;
			}
		}

		return result;
	}

}
