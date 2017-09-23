/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package saurabh.Interface.Java9;

@SuppressWarnings("unused")
public interface ReportGeneratorJava9 {
	/**
	 * Need to get implemented as per ReportGenerator class
	 */
	void generateReport(String reportData, String schema);

	/**
	 * Reading the report data from DB
	 */
	private String getReportDataFromDB() {
		System.out.println("Reading the data from DB ....");
		//logic to get the data from DB
		String reportData = "data from DB";
		return formatData(reportData);
	}

	/**
	 * Reading the report data from FileSystem
	 */
	private String getReportDataFromFile() {
		System.out.println("Reading the data from FileSystem ....");
		//logic to get the data from File
		String reportData = "data from File";
		return formatData(reportData);
	}

	/**
	 * Reading the report data from cache
	 */
	private String getReportDataFromCache() {
		System.out.println("Reading the data from Cache ....");
		//logic to get the data from Cache
		String reportData = "data from Cache";
		return formatData(reportData);
	}

	/**
	 * Formatting the data to create a common standardized data,
	 * as it's coming from different systems
	 */
	private String formatData(String reportData) {
		System.out.println("Formatting the data to create a common standard");
		/* Format the data and then return **/
		//logic to format the data
		return reportData;
	}

	/**
	 * Get the ready data
	 */
	default String getReportData(String reportSource) throws Exception {
		String reportData = null;
		if (null == reportSource) {
			throw new Exception("reportSource can't be null....");
		}
		if (reportSource.equalsIgnoreCase("DB")) {
			reportData = getReportDataFromDB();
		} else if (reportSource.equalsIgnoreCase("File")) {
			reportData = getReportDataFromFile();
		} else if (reportSource.equalsIgnoreCase("Cache")) {
			reportData = getReportDataFromCache();
		}
		return reportData;
	}
}