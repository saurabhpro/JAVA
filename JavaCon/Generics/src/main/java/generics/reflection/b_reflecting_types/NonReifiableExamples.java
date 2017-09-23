/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package generics.reflection.b_reflecting_types;

import java.util.ArrayList;
import java.util.List;

public class NonReifiableExamples<T> {
	public static void main(String[] args) {
		new NonReifiableExamples<String>().main();
	}

	private void main() {
		// System.out.println(T.class);

		List<String> strings = new ArrayList<>();
		System.out.println(strings.getClass());
		List<Integer> integers = new ArrayList<>();
		List raw = new ArrayList();

		System.out.println(strings.getClass() == integers.getClass());
		System.out.println(raw.getClass() == integers.getClass());

		List<? extends Number> numbers = new ArrayList<>();
		System.out.println(numbers.getClass());
		System.out.println(numbers.getClass() == integers.getClass());
	}
}
