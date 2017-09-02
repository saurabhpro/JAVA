package pluralsight.testing.csvsalesreport.spring_xmlDI;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pluralsight.testing.csvsalesreport.common.DEFAULTS;

import java.io.PrintStream;

public class SpringXmlSalesReportRunner {

	private static String fileLocation;

	public static void main(String[] args) {

		if (args.length < 1) {
			/*System.err.println("You must provide a commandline argument specifying the file to analyse");
			System.exit(-1);*/

			fileLocation = DEFAULTS.FILE_LOCATION;
		} else
			fileLocation = args[0];


		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext(
				"application-context.xml");

		SalesReport report = xmlContext.getBean(SalesReport.class);
		report.report();
	}

	public static PrintStream getOutput() {
		return System.out;
	}

	public static String getFileLocation() {
		return fileLocation;
	}

}
