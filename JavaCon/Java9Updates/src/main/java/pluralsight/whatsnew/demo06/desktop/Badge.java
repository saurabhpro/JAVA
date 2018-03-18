/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.whatsnew.demo06.desktop;

import java.awt.*;

public class Badge {

	public static void main(String[] args) throws Exception {

		Frame frame = new Frame();
		frame.setSize(400, 400);
		frame.setVisible(true);


		if (Taskbar.isTaskbarSupported()) {
			Taskbar taskbar = Taskbar.getTaskbar();
			if (taskbar.isSupported(Taskbar.Feature.ICON_BADGE_TEXT)) {
				Thread.sleep(2000);
				taskbar.setIconBadge("test!");
			}
		}

	}
}
