package testing.junit.m5.after_refactor;

import testing.junit.m5.common.SalesAnalysisServiceBase;
import testing.junit.m5.common.SalesReportBase;

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
