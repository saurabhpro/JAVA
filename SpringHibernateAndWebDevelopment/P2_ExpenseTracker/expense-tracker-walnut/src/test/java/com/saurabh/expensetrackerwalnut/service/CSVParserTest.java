package com.saurabh.expensetrackerwalnut.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CSVParserTest {
	@Test
	@DisplayName("file name of the csv to be parsed")
	void testFileName() {
		String expected = "/Users/saurabhkumar/GitHub/JAVA/SpringHibernateAndWebDevelopment/P2_ExpenseTracker/expense-tracker-walnut/src/main/resources/sample-files/walnut_expense_report_01-02-2016_to_31-07-2017.csv";
		Assertions.assertEquals(expected, CSVParser.fileName);
	}

	@Test
	void testCommaReplacement() {
		String expected = "-";
		Assertions.assertEquals(expected, CSVParser.MISPLACED_COMMA_REPLACEMENT);
	}

	@Test
	void testCSVSeparator() {
		String expected = ",";
		Assertions.assertEquals(expected, CSVParser.CSV_SEPARATOR);
	}
}