package pluralsight.testing.csvsalesreport.manualDI;

import pluralsight.testing.csvsalesreport.common.DEFAULTS;

public class SimpleReportRunner {

	public static void main(String[] args) {

		String fileLocation;
		if (args.length < 1) {
			/*System.err.println("You must provide a commandline argument specifying the file to analyse");
			System.exit(-1);*/

			fileLocation = DEFAULTS.FILE_LOCATION;
		} else
			fileLocation = args[0];

		CsvSalesRepository repo = new CsvSalesRepository(fileLocation);

		repo.setError(System.err);

		//manual service injection
		SalesAnalysisService analysisService = new SalesAnalysisService(repo);

		SalesReport report = new SalesReport(System.out, analysisService);

		report.report();
	}

}
