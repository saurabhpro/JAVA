/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package streams.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMapFilteringComparision {

	public static void main(String[] args) {

		Map<Integer, String> HOSTING = new HashMap<>();
		HOSTING.put(1, "linode.com");
		HOSTING.put(2, "heroku.com");
		HOSTING.put(3, "digitalocean.com");
		HOSTING.put(4, "aws.amazon.com");

		String result = "";
		for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
			if ("aws.amazon.com".equals(entry.getValue())) {
				result = entry.getValue();
			}
		}
		System.out.println("Before Java 8 : " + result);

		//Map -> Stream -> Filter -> String
		//noinspection Convert2MethodRef
		result = HOSTING.entrySet().stream()
				.filter(map -> "aws.amazon.com".equals(map.getValue()))
				.map(map -> map.getValue())
				.collect(Collectors.joining());

		System.out.println("With Java 8 + lambda : " + result);

		//Map -> Stream -> Filter -> String
		result = HOSTING.entrySet().stream()
				.filter(map -> "aws.amazon.com".equals(map.getValue()))
				.map(Map.Entry::getValue)
				.collect(Collectors.joining());

		System.out.println("With Java 8 with method reference: " + result);

	}
}