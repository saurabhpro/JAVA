package pluralsight.testing.csvsalesreport.guiceDI;

import com.google.inject.Guice;
import com.google.inject.Injector;
import pluralsight.testing.csvsalesreport.common.DEFAULTS;

public class GuiceSalesReportRunner {

	public static void main(String[] args) {

		String fileLocation;
		if (args.length < 1) {
			/*System.err.println("You must provide a commandline argument specifying the file to analyse");
			System.exit(-1);*/

			fileLocation = DEFAULTS.FILE_LOCATION;
		} else
			fileLocation = args[0];

		Injector injector = Guice.createInjector(new SalesModule(fileLocation));

		SalesReport report = injector.getInstance(SalesReport.class);

		report.report();
	}

}
