/**
 * Created by saurabhkumar on 31/07/17.
 */
public class J_OddOneInPairs {

	static int oddOneInPair(int[] numList) {
		int result = numList[0];

		for (int i = 1; i < numList.length; i++) {
			result ^= numList[i];
		}

		return result;
	}
}
