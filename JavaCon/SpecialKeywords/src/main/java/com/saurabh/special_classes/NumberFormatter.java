/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special_classes;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatter {
	public static void main(String[] args) {

		System.out.println("\n**********roundingAndPrecision**********");
		roundingAndPrecision();

		System.out.println("\n***********currencyFormatted*********");
		currencyFormatted();

		System.out.println("\n**********commaFixer**********");
		commaFixer();

		System.out.println("\n***********groupingDesigner*********");
		groupingDesigner();

	}

	private static void groupingDesigner() {
		long val3 = 23_500_390_800_380L;       //since java 7

		NumberFormat nf1 = NumberFormat.getInstance(new Locale("sk", "SK"));
		nf1.setGroupingUsed(true);

		System.out.println(nf1.format(val3));

		nf1.setGroupingUsed(false);

		System.out.println(nf1.format(val3));

		/*
		***********groupingDesigner*********
		23 500 390 800 380
		23500390800380
		 */
	}

	private static void commaFixer() {
		double n = 1240.35;
		NumberFormat nf3 = NumberFormat.getInstance(new Locale("de", "AU"));    // de = german , AU = Austria
		System.out.println(nf3.format(n));

		/*
		**********commaFixer**********
		1.240,35
		 */
	}

	private static void currencyFormatted() {
		int val = 23_500;       //since java 7

		NumberFormat cf1 = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
		System.out.println(cf1.format(val));

		/*
		***********currencyFormatted*********
		Rs. 23,500.00
		 */
	}

	private static void roundingAndPrecision() {
		double val1 = 4.5678934;
		double val2 = 2.3;

		NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));

		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(4);

		nf.setRoundingMode(RoundingMode.DOWN);

		System.out.println(nf.format(val1));
		System.out.println(nf.format(val2));

		/*
		**********roundingAndPrecision**********
		4.5678
		2.30
		 */
	}
}
