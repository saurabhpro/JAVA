/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.saurabh.special.pattern;

class StringMatcher {
	// returns true if the string matches exactly "true"
	public boolean isTrue(String s) {
		return s.matches("true");
	}

	// returns true if the string matches exactly "true" or "True"
	public boolean isTrueVersion2(String s) {
		return s.matches("[tT]rue");
	}

	// returns true if the string matches exactly "true" or "True"
	// or "yes" or "Yes"
	public boolean isTrueOrYes(String s) {
		return s.matches("[tT]rue|[yY]es");
	}

	// returns true if the string contains exactly "true"
	public boolean containsTrue(String s) {
		return s.matches(".*true.*");
	}


	// returns true if the string contains of three letters
	public boolean isThreeLetters(String s) {
		return s.matches("[a-zA-Z]{3}");
		// simpler from for
//      return s.matches("[a-Z][a-Z][a-Z]");
	}


	// returns true if the string does not have a number at the beginning
	public boolean isNoNumberAtBeginning(String s) {
		return s.matches("^[^\\d].*");
	}

	// returns true if the string contains a arbitrary number of characters except b
	public boolean isIntersection(String s) {
		return s.matches("([\\w&&[^b]])*");
	}

	// returns true if the string contains a number less than 300
	public boolean isLessThenThreeHundred(String s) {
		return s.matches("[^0-9]*[12]?[0-9]{1,2}[^0-9]*");
	}

}