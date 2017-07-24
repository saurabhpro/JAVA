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

	static boolean validateRomanNumber(String num) {
		boolean check = true;
		char[] romanCharacters = num.toCharArray();

		if (romanCharacters.length == 1) {
			check = integerValueForRomanCharacter(romanCharacters[0]) != -1;
		} else {
			for (int i = 0; i < romanCharacters.length - 1; i++) {
				if (romanCharacters[i] == 'I' && (romanCharacters[i + 1] != 'V' || romanCharacters[i + 1] != 'X'))
					check = false;
				else if (romanCharacters[i] == 'X' && (romanCharacters[i + 1] != 'L' || romanCharacters[i + 1] != 'C' || romanCharacters[i + 1] != 'X'))
					check = false;
				else if (romanCharacters[i] == 'C' && (romanCharacters[i + 1] != 'D' || romanCharacters[i + 1] != 'M'))
					check = false;
			}
		}
		return check;
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
