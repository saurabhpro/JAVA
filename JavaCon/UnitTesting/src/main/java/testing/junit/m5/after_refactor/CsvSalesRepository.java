package testing.junit.m5.after_refactor;


import testing.junit.m5.common.Sale;
import testing.junit.m5.common.SalesRepositoryBase;

import java.io.PrintStream;
import java.util.List;

public class CsvSalesRepository implements SalesRepositoryBase {

	private final String fileLocation;
	private PrintStream error;
	private List<Sale> sales;

	public CsvSalesRepository(String fileLocation) {
		this.fileLocation = fileLocation;
		error = System.out;
	}

	public void setError(PrintStream error) {
		this.error = error;
	}

	public List<Sale> loadSales() {
		return loadSales(sales, fileLocation, error);
	}
}
