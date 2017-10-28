/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.saurabh.special_classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatExample {
	public static void main(String[] args) {
		usingSimpleDateFormat();

		usingDateFormatInstance();

		usingDateTimeFormatter();
	}

	private static void usingDateTimeFormatter() {
		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;

		String formattedDate = formatter.format(LocalDate.now());
		System.out.println(formattedDate);
		// 20171028
	}

	private static void usingSimpleDateFormat() {
		Date date = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		System.out.println(strDate);
		// 28/10/2017

		formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
		strDate = formatter.format(date);
		System.out.println("Date Format with E, dd MMM yyyy HH:mm:ss z => " + strDate);
		// Date Format with E, dd MMM yyyy HH:mm:ss z => Sat, 28 Oct 2017 22:13:44 IST


		formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = formatter.parse("31/03/2018");
			System.out.println("Date is: " + date);
			// Date is: Sat Mar 31 00:00:00 IST 2018
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


	private static void usingDateFormatInstance() {
		Date currentDate = new Date();
		System.out.println("Current Date: " + currentDate);

		String dateToStr = DateFormat.getInstance().format(currentDate);
		System.out.println(dateToStr);

		dateToStr = DateFormat.getDateInstance().format(currentDate);
		System.out.println(dateToStr);

		dateToStr = DateFormat.getTimeInstance().format(currentDate);
		System.out.println(dateToStr);

		dateToStr = DateFormat.getDateTimeInstance().format(currentDate);
		System.out.println(dateToStr);

		dateToStr = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(currentDate);
		System.out.println(dateToStr);

		dateToStr = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT).format(currentDate);
		System.out.println(dateToStr);


		try {
			Date d = DateFormat.getDateInstance().parse("28-Oct-2017");
			//this fails parsing since localized date here isn't "31 March, 2018"

			System.out.println("Date is: " + d);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}  