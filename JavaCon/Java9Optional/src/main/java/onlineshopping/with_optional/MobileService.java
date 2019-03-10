/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package onlineshopping.with_optional;

import onlineshopping.limited.ScreenResolution;

import java.util.Optional;

public class MobileService {

	@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
	public Integer getMobileScreenWidth(Optional<Mobile> mobile) {

		return mobile.flatMap(Mobile::getDisplayFeatures)
				.flatMap(DisplayFeatures::getResolution)
				.map(ScreenResolution::getWidth)
				.orElse(0);

	}

}