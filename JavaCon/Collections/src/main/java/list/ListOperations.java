/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListOperations {

	public static void main(String[] args) {

		List<Integer> la = new ArrayList<>(5);
		la.add(0, 44);
		//System.out.println(la);


		Name n1 = new Name("1");
		Name n2 = new Name("2");
		Name n3 = new Name("3");
		Name n4 = new Name("4");
		Name n5 = new Name("5");
		Name n6 = new Name("6");

		List<Name> al = Arrays.asList(n1, n2, n3, n4);

		Name ret = al.set(1, n6);  // Replaces the element at the specified position in this list = -1 (returned)
		// with the specified element (56) (optional operation).

		// as List returns unmodifiable list ?
		System.out.println(ret + " and the final list = " + al);

		// unsupported as .asList() returns immutable list
		//al.add(1, 56);
		//al.remove(1);

		List<Name> d = Collections.emptyList();
		System.out.println(d);

		d = Collections.unmodifiableList(al);
		n4.setValue("55");
		System.out.println(d);

		List<Name> lists = Collections.singletonList(n1);
		System.out.println(lists);

		List<Name> al1 = List.of(n1, n2, n3, n4);
		n3.setValue("66");
		//ret = al1.set(1, n6);
		System.out.println(al1);
	}
}

class Name {
	private String value;

	public Name(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Name{" +
				"value='" + value + '\'' +
				'}';
	}
}
