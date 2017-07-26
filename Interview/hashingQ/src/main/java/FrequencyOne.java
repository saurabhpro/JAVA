import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s which contains lower alphabetic characters, the task is to check if its possible to  remove at most one character from this string in such a way that frequency of each distinct character becomes same in the string.
 * Examples:
 * <p>
 * Input  : s = “xyyz”
 * Output : 1
 * We can remove character ’y’ from above
 * string to make the frequency of each
 * character same.
 * <p>
 * Input : s = “xxxxyyzz”
 * Output : 0
 * It is not possible to make frequency of
 * each character same just by removing at
 * most one character from above string.
 */
class FrequencyOne {
	static boolean ifFrequencyCanBeEqualizedbyRemovingAtMostOneChar(String str) {
		HashMap<Character, Integer> hashMap = new HashMap<>();
		boolean check = true;

		for (Character c : str.toCharArray()) {
			if (hashMap.containsKey(c)) {
				hashMap.put(c, hashMap.get(c) + 1);
			} else {
				hashMap.put(c, 1);
			}
		}

		int maxFreq = Collections.max(hashMap.values());
		int minFreq = Collections.min(hashMap.values());
		int maxMismatchOne = 1;

		//Test Case 1 : if frequency variance is more than 1
		if ((maxFreq - minFreq) > 1) {
			//abbb
			if (hashMap.size() == 2 && minFreq == 1) {
				check = true;   //removing 'a' would work
			}
			//aabbcccc
			else check = false;
		} else {
			for (Map.Entry<Character, Integer> ch : hashMap.entrySet()) {
				//Test Case 2 : if frequency variance is 1 but more than once
				//Note that we can rely of the difference not being > 1 due to TC1
				//abbc
				if ((ch.getValue() - minFreq) == 1) {
					if (maxMismatchOne != 1) {
						check = false;
						break;

					}
					maxMismatchOne++;
				}
			}
		}

		return check;
	}
}