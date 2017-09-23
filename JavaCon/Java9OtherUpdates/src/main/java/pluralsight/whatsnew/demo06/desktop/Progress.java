/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.whatsnew.demo06.desktop;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Progress {

	public static void main(String[] args) throws Exception {

		Taskbar bar = Taskbar.getTaskbar();
		if (bar.isSupported(Taskbar.Feature.ICON_IMAGE)) {
			Image icon = ImageIO.read(new File("/Users/saurabhkumar/GitHub/JAVA/JavaCon/Java9OtherUpdates/src/main/resources/icon.jpg"));
			bar.setIconImage(icon);
		}

		Thread.sleep(1000);
		for (int i = 0; i <= 100; i++) {
			bar.setProgressValue(i);
			Thread.sleep(30);
		}

		bar.setIconBadge("Done!");

		// Only works if application doesn't have focus
		bar.requestUserAttention(true, true);


		Thread.sleep(7000);
	}
}
