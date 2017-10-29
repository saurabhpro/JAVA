/*
 * Copyright 2017 Saurabh Kumar 29/10/17 1:14 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.rxjava.observable.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataGenerator {

	public static List<String> generateGreekAlphabet() {

		String[] greekLetters = {
				"Alpha",
				"Beta",
				"Gamma",
				"Delta",
				"Epsilon",
				"Zeta",
				"Eta",
				"Theta",
				"Iota",
				"Kappa",
				"Lambda",
				"Mu",
				"Nu",
				"Xi",
				"Omicron",
				"Pi",
				"Rho",
				"Sigma",
				"Tau",
				"Upsilon",
				"Phi",
				"Chi",
				"Psi",
				"Omega"
		};

		ArrayList<String> returnList = new ArrayList<>();

		returnList.addAll(Arrays.asList(greekLetters));

		return returnList;
	}

	public static List<String> generateScrambledAndDuppedGreekAlphabet() {

		ArrayList<String> returnList = new ArrayList<>();

		returnList.addAll(generateGreekAlphabet());
		returnList.addAll(generateGreekAlphabet());
		returnList.addAll(generateGreekAlphabet());

		// shuffling the result
		Collections.shuffle(returnList);

		return returnList;
	}

	public static List<Integer> generateBigIntegerList() {

		ArrayList<Integer> returnList = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			returnList.add(i);
		}

		return returnList;
	}

	public static void emitFibonacciList(List<Integer> emitList) {

		emitList.add(1);
		emitList.add(2);
		emitList.add(3);
		emitList.add(5);
		emitList.add(8);
		emitList.add(13);
		emitList.add(21);
		emitList.add(34);
	}

	public static List<Integer> generateFibonacciList() {

		ArrayList<Integer> returnList = new ArrayList<>();
		returnList.add(1);
		returnList.add(2);
		returnList.add(3);
		returnList.add(5);
		returnList.add(8);
		returnList.add(13);
		returnList.add(21);
		returnList.add(34);

		return returnList;
	}

	public static Integer[] generateFibonacciArray() {

		return new Integer[]{
				1, 2, 3, 5, 8, 13, 21, 34
		};
	}

	public static List<String> generateEnglishAlphabet() {

		ArrayList<String> returnList = new ArrayList<>();
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			returnList.add(new String(new char[]{ch}));
		}

		return returnList;
	}

}
