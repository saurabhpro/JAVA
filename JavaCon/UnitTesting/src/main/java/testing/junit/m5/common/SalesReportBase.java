package testing.junit.m5.common;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Map;

/**
 * Created by saurabhkumar on 21/05/17.
 */
public class SalesReportBase<T extends SalesAnalysisServiceBase> implements SalesReportPrinter {
	protected PrintStream output = null;
	protected T analyser = null;

	public void report() {
		output.printf("\nSales Report for %s\n%n", LocalDate.now());

		printTable("Store Sales", analyser.tallyStoreSales());
		printTable("Product Sales", analyser.tallyProductSales());
	}

	protected void printTable(String title, Map<String, Integer> values) {
		printSalesReport(title, values, output);
	}
}
