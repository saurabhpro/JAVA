package com.saurabh.service.helper.utility;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StringIdToListOfIdMapper {

	public static void mapStringIdsToListOfIds(List<String> listOfIds, String tmp) {
		String[] temp2 = tmp.substring(1, tmp.length() - 1).split(",");

		for (String t : temp2) {
			if (!t.equals(""))
				listOfIds.add(t.substring(1, t.length() - 1));
			else
				listOfIds.add(null);
		}
	}
}