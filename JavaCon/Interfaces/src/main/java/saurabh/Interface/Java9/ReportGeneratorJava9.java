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