package pluralsight.testing.csvsalesreport.manualDI;

import pluralsight.testing.csvsalesreport.common.SalesAnalysisServiceBase;
import pluralsight.testing.csvsalesreport.common.SalesReportBase;

import java.io.PrintStream;

public class SalesReport extends SalesReportBase {

	<T extends SalesAnalysisServiceBase> SalesReport(PrintStream output, T analyser) {
		super.output = output;
		super.analyser = analyser;
	}

	public void report() {
		super.report();
	}
}
