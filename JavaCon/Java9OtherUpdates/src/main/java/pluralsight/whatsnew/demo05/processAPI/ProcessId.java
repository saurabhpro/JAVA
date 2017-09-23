/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.whatsnew.demo05.processAPI;

import java.lang.management.ManagementFactory;

public class ProcessId {
	public static void main(String... args) {

		// Before Java 9 :(
		long pidOld = Long.parseLong(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);

		// With the new ProcessHandle API in Java 9:
		long pidNew = ProcessHandle.current().pid();
		long parentPid = ProcessHandle.current().parent().get().pid();

		System.out.println(String.format("{ pidOld: %s, pidNew: %s }\nparentPid (IDE): %s", pidOld, pidNew, parentPid));
	}
}