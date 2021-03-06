package pluralsight.testing.csvsalesreport.guiceDI;

import pluralsight.testing.csvsalesreport.common.SalesRepositoryBase;
import pluralsight.testing.csvsalesreport.common.model.Sale;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.PrintStream;
import java.util.List;

public class CsvSalesRepository implements SalesRepositoryBase {

	private final String fileLocation;
	private PrintStream error;
	private List<Sale> sales;

	@Inject
	public CsvSalesRepository(@Named("fileLocation") String fileLocation) {
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
