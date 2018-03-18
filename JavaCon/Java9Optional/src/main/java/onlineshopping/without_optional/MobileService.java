/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package onlineshopping.without_optional;

import onlineshopping.limited.ScreenResolution;

public class MobileService {

	public int getMobileScreenWidth(Mobile mobile) {

		if (mobile != null) {
			DisplayFeatures mobileDisplayFeatures = mobile.getDisplayFeatures();
			if (mobileDisplayFeatures != null) {
				ScreenResolution resolution = mobileDisplayFeatures.getResolution();
				if (resolution != null) {
					return resolution.getWidth();
				}
			}
		}

		return 0;

	}

}