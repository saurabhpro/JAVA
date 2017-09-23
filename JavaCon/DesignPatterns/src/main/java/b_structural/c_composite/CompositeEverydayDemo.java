/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package b_structural.c_composite;

import java.util.HashMap;
import java.util.Map;

public class CompositeEverydayDemo {

	public static void main(String args[]) {
		Map<String, String> personAttributes = new HashMap<>();

		personAttributes.put("site_role", "person");
		personAttributes.put("access_role", "limited");

		Map<String, String> groupAttributes = new HashMap<>();

		groupAttributes.put("group_role", "claims");

		Map<String, String> secAttributes = new HashMap<>();

		secAttributes.putAll(personAttributes);
		secAttributes.putAll(groupAttributes);

		System.out.println(secAttributes);
	}
}
