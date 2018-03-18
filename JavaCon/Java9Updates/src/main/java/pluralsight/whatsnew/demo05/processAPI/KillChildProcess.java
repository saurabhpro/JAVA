/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.whatsnew.demo05.processAPI;

import java.io.IOException;

public class KillChildProcess {

	public static void main(String... args) throws IOException {
		Process process =
				new ProcessBuilder("bash", "-c", "while true; do sleep 1; done").start();

		ProcessHandle handle = process.toHandle();
		handle.onExit().thenAccept(p -> System.out.println("Process " + p + " was killed"));

		System.out.println("Press enter to continue");
		System.in.read();

		if (handle.supportsNormalTermination()) {
			System.out.println("Killing process");
			handle.destroy();
		}

		System.out.println("Press enter to finish");
		System.in.read();

	}
}
