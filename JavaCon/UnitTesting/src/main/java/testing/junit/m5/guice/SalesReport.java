package testing.junit.m5.guice;

import org.springframework.stereotype.Component;
import testing.junit.m5.common.SalesReportBase;

import javax.inject.Inject;
import java.io.PrintStream;
import java.time.LocalDate;

@Component
public class SalesReport extends SalesReportBase {

	private final PrintStream output;
	private final SalesAnalysisService analyser;

	@Inject
	public SalesReport(PrintStream output, SalesAnalysisService analyser) {
		this.output = output;
		this.analyser = analyser;
	}

	public void report() {
		output.printf("\nSales Report for %s\n%n", LocalDate.now());

		printTable("Store Sales", analyser.tallyStoreSales());
		printTable("Product Sales", analyser.tallyProductSales());
	}
}
