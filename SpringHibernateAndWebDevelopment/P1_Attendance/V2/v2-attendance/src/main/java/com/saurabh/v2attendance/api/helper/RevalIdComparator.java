/*
 * Copyright (c) 2016.
 */

package com.saurabh.v2attendance.api.helper;

import org.springframework.stereotype.Component;

import java.util.Comparator;

/**
 * @author Saurabh
 * @version 1.0
 */
@Component
public final class RevalIdComparator implements Comparator<String> {
	/**
	 * @param id1 treemap key new
	 * @param id2 treemap key old
	 * @return compareTo values by comparing two Reval Id's in treemap
	 */
	@Override
	public int compare(String id1, String id2) {
		int i = Integer.parseInt(id1.substring(1));
		int j = Integer.parseInt(id2.substring(1));

		return Integer.compare(i, j);
	}

}
