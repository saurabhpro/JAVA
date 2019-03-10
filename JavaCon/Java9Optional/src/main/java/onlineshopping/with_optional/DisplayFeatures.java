/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package onlineshopping.with_optional;

import onlineshopping.limited.ScreenResolution;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class DisplayFeatures {

	private String size; // In inches

	/**
	 * Reports any uses of java.util.Optional<T>, java.util.OptionalDouble, java.util.OptionalInt,
	 * java.util.OptionalLong or com.google.common.base.Optional as the type for a field or a parameter.
	 * <p>
	 * Optional was designed to provide a limited mechanism for library method return types
	 * where there needed to be a clear way to represent "no result".
	 * <p>
	 * Using a field with type java.util.Optional is also problematic if the class needs to be Serializable,
	 * which java.util.Optional is not.
	 */
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