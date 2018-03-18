/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMapFilteringComparision {

	public static void main(String[] args) {

		Map<Integer, String> HOSTING = new HashMap<>();
		HOSTING.put(1, "linode.com");
		HOSTING.put(2, "heroku.com");
		HOSTING.put(3, "digitalocean.com");
		HOSTING.put(4, "aws.amazon.com");

		String result = "";
		for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
			if ("aws.amazon.com".equals(entry.getValue())) {
				result = entry.getValue();
			}
		}
		System.out.println("Before Java 8 : " + result);

		//Map -> Stream -> Filter -> String
		//noinspection Convert2MethodRef
		result = HOSTING.entrySet().stream()
				.filter(map -> "aws.amazon.com".equals(map.getValue()))
				.map(map -> map.getValue())
				.collect(Collectors.joining());

		System.out.println("With Java 8 + lambda : " + result);

		//Map -> Stream -> Filter -> String
		result = HOSTING.entrySet().stream()
				.filter(map -> "aws.amazon.com".equals(map.getValue()))
				.map(Map.Entry::getValue)
				.collect(Collectors.joining());

		System.out.println("With Java 8 with method reference: " + result);

	}
}