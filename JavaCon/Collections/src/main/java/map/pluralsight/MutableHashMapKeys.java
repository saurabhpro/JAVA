/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package map.pluralsight;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MutableHashMapKeys {
	public static void main(String[] args) {
		final Map<MutableString, String> brokenMap = new HashMap<>();

		final String value = "abc";

		final MutableString key = new MutableString(value);
		brokenMap.put(key, value);

		System.out.println(brokenMap.get(key));
		System.out.println(brokenMap);

		key.set("def");

		System.out.println(brokenMap.get(key));
		System.out.println(brokenMap);
	}

	private static class MutableString {
		private String value;

		MutableString(final String value) {
			set(value);
		}

		public String get() {
			return value;
		}

		void set(final String value) {
			Objects.requireNonNull(value);
			this.value = value;
		}

		public boolean equals(final Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			final MutableString that = (MutableString) o;

			return value.equals(that.value);
		}

		public int hashCode() {
			return value.hashCode();
		}

		public String toString() {
			return value;
		}
	}
}
