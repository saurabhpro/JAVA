/*
 * Copyright (c) 2018 Saurabh Kumar
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