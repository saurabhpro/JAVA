/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package general;

import java.lang.StackWalker.StackFrame;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * StackWalker gives the snapshot of the stack trace of the current thread at any given point of time and has methods to walk over it. Benefits of using StackWalker over Thread::getStackTrace() (prior to JDK9), which are missing in prior releases, are:
 * <p>
 * Filter / assert / skip certain classes.
 * <p>
 * Get the instance of declaring the class itself.
 * <p>
 * Get either short stack trace or complete stack trace, instead of pulling the complete stack trace itself.
 */
public class StackWalkerExample {

	public static void main(String args[]) {

		System.out.println("StackWalkerExample...");
		new StackWalkerExample().stackWalk();
	}

	private void stackWalk() {
		new StackWalker1().stackWalk1();
	}

	private class StackWalker1 {
		void stackWalk1() {
			new StackWalker2().stackWalk2();
		}
	}

	private class StackWalker2 {
		void stackWalk2() {
			new StackWalker3().stackWalk3();
		}
	}

	private class StackWalker3 {
		void stackWalk3() {
			new StackWalker4().stackWalk4();
		}
	}

	private class StackWalker4 {

		void stackWalk4() {

			StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
			List<StackFrame> stack = stackWalker.walk((s) -> s.collect(Collectors.toList()));


			System.out.println("\n\n----------------------First Block Begins--------------------");

			System.out.println("All frames : \n" + stack.toString());

			//stackFrame.getDeclaringClass() -> Will give instance of declaring class
			stack.stream()
					.map(stackFrame -> stackFrame.getDeclaringClass().toString())
					.forEach(System.out::println);

			System.out.println("\n\n----------------------\n\nSecond Block Begins--------------------");

			// Filter for interesting classes
			final List<Class> interestingClasses = new ArrayList<>();
			interestingClasses.add(StackWalker3.class);

			stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

			Optional<StackFrame> framesWithInterestingClass = stackWalker
					.walk((s)
							-> s.filter(f -> interestingClasses.contains(f.getDeclaringClass()))
							.findFirst()
					);

			System.out.println("Frame with interesting class : \n" + framesWithInterestingClass.toString());

			System.out.println("\n\n----------------------Third Block Begins--------------------");

			/* Trim the stack frame by skipping a few classes. Using this, we can consider short stack frames */
			// Frames with skip
			stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

			List<StackFrame> framesAfterSkip = stackWalker
					.walk((s) -> s.skip(2)
							.collect(Collectors.toList())
					);
			System.out.println("Frames after skip : \n" + framesAfterSkip.toString());
		}
	}


}