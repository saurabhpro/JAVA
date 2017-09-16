package com.saurabh.utils;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.function.IntSupplier;

@Component
public class Utils {

	private Random random;

	public Utils() {
		random = new Random();
	}

	public String generateRandomChars(String pattern, int length) {

		return random.ints(0, pattern.length())
				.mapToObj(i -> pattern.charAt(i))
				.limit(length)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();
	}

	public Integer generateRandonInteger(Integer integer) {

		// Learn what is intsupplier
		IntSupplier intSupplier = new IntSupplier() {
			@Override
			public int getAsInt() {
				return 10;
			}
		};

		return random.ints(integer, 80)
				.findAny()
				//.getAsInt();  fails if no int could be found for some reason
				.orElseGet(intSupplier);
	}
}