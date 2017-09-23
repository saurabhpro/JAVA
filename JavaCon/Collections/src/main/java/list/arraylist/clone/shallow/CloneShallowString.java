/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package list.arraylist.clone.shallow;

import java.util.ArrayList;

/**
 * Created by Saurabh on 9/6/2015.
 */

public class CloneShallowString {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		//adding elements to end
		al.add("First");
		al.add("Second");
		al.add("Third");
		al.add("Random");

		System.out.println("Actual ArrayList " + al);

		ArrayList<String> copy = (ArrayList<String>) al.clone();
		System.out.println("Cloned ArrayList " + copy);

		//if (al.get(0) == copy.get(0)) comparing two strings using == instead of equals()
		if (al.get(0).equals(copy.get(0)))       //compares references not strings
			System.out.println("Shallow");
		if (al != copy)
			System.out.println("Clone Made");
	}
}
