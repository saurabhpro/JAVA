/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

// FunctionUtil.java

package apress.util.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionUtil {
	// Applies an action on each item in a list
	public static <T> void forEach(List<T> list, Consumer<? super T> action) {
		for (T item : list) {
			action.accept(item);
		}
	}

	// Applies a filter to a list and returned the filtered list items
	public static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
		List<T> filteredList = new ArrayList<>();
		for (T item : list) {
			if (predicate.test(item)) {
				filteredList.add(item);
			}
		}
		return filteredList;
	}

	// Maps each item in a list to a value
	public static <T, R> List<R> map(List<T> list, Function<? super T, R> mapper) {
		List<R> mappedList = new ArrayList<>();
		for (T item : list) {
			mappedList.add(mapper.apply(item));

		}
		return mappedList;
	}
}
