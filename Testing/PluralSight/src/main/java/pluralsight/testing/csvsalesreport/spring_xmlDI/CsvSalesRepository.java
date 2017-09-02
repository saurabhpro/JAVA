package pluralsight.testing.csvsalesreport.spring_xmlDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pluralsight.testing.csvsalesreport.common.SalesRepositoryBase;
import pluralsight.testing.csvsalesreport.common.model.Sale;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.PrintStream;
import java.util.List;

@Component
public class CsvSalesRepository implements SalesRepositoryBase {

	private final String fileLocation;
	private PrintStream error;
	private List<Sale> sales;

	@Autowired
	@Inject
	public CsvSalesRepository(@Named("fileLocation") @Qualifier("fileLocation") String fileLocation) {
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
