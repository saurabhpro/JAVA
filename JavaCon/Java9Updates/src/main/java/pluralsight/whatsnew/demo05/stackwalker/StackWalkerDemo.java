/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.whatsnew.demo05.stackwalker;

import java.lang.StackWalker.StackFrame;
import java.util.List;
import java.util.stream.Collectors;

public class StackWalkerDemo {
	public static void main(String... args) {
		method1();
	}

	private static void method1() {
		method2();
	}

	private static void method2() {
		method3();
	}

	private static void method3() {
		method4();
	}

	private static void method4() {
		StackWalker walker = StackWalker.getInstance();

		//handling all stack-frames
		walker.forEach(System.out::println);

		List<Integer> lines = walker.walk(stackStream ->
				stackStream
						.filter(f -> f.getMethodName().startsWith("m"))
						.map(StackFrame::getLineNumber)
						.collect(Collectors.toList())
		);

		lines.forEach(System.out::println);
	}

}
