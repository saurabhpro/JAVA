package pluralsight.testing.csvsalesreport.spring_xmlDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pluralsight.testing.csvsalesreport.common.SalesReportBase;

import java.io.PrintStream;
import java.time.LocalDate;

@Component
public class SalesReport extends SalesReportBase<SalesAnalysisService> {

	private final PrintStream output;
	private final SalesAnalysisService analyser;

	@Autowired
	public SalesReport(PrintStream output, SalesAnalysisService analyser) {
		this.output = output;
		this.analyser = analyser;
	}

	public void report() {
		output.printf("\nSales Report for %s\n%n", LocalDate.now());

		printTable("Store Sales", analyser.tallyStoreSales(), output);
		printTable("Product Sales", analyser.tallyProductSales(), output);
	}
}
