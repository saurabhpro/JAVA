/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package onlineshopping.without_optional;

import onlineshopping.limited.ScreenResolution;

public class DisplayFeatures {

	private String size; // In inches
	private ScreenResolution resolution;

	public DisplayFeatures(String size, ScreenResolution resolution) {
		this.size = size;
		this.resolution = resolution;
	}

	public String getSize() {
		return size;
	}


	public ScreenResolution getResolution() {
		return resolution;
	}

}