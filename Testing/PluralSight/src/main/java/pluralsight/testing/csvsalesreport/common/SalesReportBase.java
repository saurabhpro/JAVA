package pluralsight.testing.csvsalesreport.common;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Map;

public class SalesReportBase<T extends SalesAnalysisServiceBase> implements SalesReportPrinter {
	protected PrintStream output = null;
	protected T analyser = null;

	public void report() {
		output.printf("\nSales Report for %s\n%n", LocalDate.now());

		printTable("Store Sales", analyser.tallyStoreSales(), output);
		printTable("Product Sales", analyser.tallyProductSales(), output);
	}

	protected void printTable(String title, Map<String, Integer> values, PrintStream output) {
		printSalesReport(title, values, output);
	}
}
