/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package onlineshopping.with_optional;

import onlineshopping.limited.ScreenResolution;

import java.util.Optional;

public class DisplayFeatures {

	private String size; // In inches
	private Optional<ScreenResolution> resolution;

	public DisplayFeatures(String size, Optional<ScreenResolution> resolution) {
		this.size = size;
		this.resolution = resolution;
	}

	public String getSize() {
		return size;
	}

	public Optional<ScreenResolution> getResolution() {
		return resolution;
	}

}