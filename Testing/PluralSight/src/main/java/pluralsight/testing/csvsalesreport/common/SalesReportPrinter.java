package pluralsight.testing.csvsalesreport.common;

import java.io.PrintStream;
import java.util.Map;

/**
 * Created by saurabhkumar on 21/05/17.
 */
public interface SalesReportPrinter {

	default void printRow(String first, String second, PrintStream output) {
		output.printf("- %-15s - %6.6s -%n", first, second);
	}

	default void printSalesReport(String title, Map<String, Integer> values, PrintStream output) {
		output.printf("---------- %s ----------%n", title);
		printRow(title, "Value", output);
		values.forEach((key, value) -> printRow(key, "" + value, output));
		output.println();
		output.println();
	}
}
