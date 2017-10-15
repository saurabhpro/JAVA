package com.saurabh.expensetrackerwalnut.service;

import java.util.List;

public interface CSVParser<T> {
	String fileName = "/Users/saurabhkumar/GitHub/JAVA/SpringHibernateAndWebDevelopment/P2_ExpenseTracker/expense-tracker-walnut/src/main/resources/sample-files/walnut_expense_report_01-02-2016_to_31-07-2017.csv";

	void parseCSVHeader(String fileName);

	List<T> parseCSVBody(String fileName);
}
