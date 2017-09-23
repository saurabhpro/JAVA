/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package list.synchronizedlist.problem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Saurabh on 9/13/2015.
 * java.util.ConcurrentModificationException
 * When main.java.list.synchronizedlist.Thread1 comes back, it will throw  this Exception
 */
@SuppressWarnings("unchecked")
class ArrayListThread1 implements Runnable {
	private final ArrayList<String> al;

	ArrayListThread1(ArrayList<String> al) {
		this.al = al;
	}

	@Override
	public void run() {
		Iterator i = al.iterator();

		//or simply do = for (String x : al)
		//noinspection WhileLoopReplaceableByForEach
		while (i.hasNext()) {
			try {
				String str = (String) i.next();
				System.out.println("Name: " + str);

				Thread.sleep(2000);
			} catch (Exception e) {
				{
					System.out.println("Explain Ready = " + e);
					System.exit(0);
				}
			}
		}
	}
}
