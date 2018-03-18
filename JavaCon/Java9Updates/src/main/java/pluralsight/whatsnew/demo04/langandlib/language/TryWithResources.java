/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.whatsnew.demo04.langandlib.language;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class TryWithResources {

	public static Logger logger = Logger.getLogger(TryWithResources.class.getName());

	public void normalTryWithResources() throws IOException {
		try (FileInputStream fis = new FileInputStream("~/tmp/test")) {
			fis.read();
		}
	}

	public void doWithFile(FileInputStream fis) throws IOException {

		// fis = null; // Re-assignment makes fis not 'effectively final'
		try (FileInputStream fis2 = fis) {
			fis2.read();
		}

		// Only if fis is 'effectively final', can this form be used
		try (fis) {
			fis.read();
		}

	}
}
