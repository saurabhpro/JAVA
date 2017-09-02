package pluralsight.testing.csvsalesreport.spring_xmlDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pluralsight.testing.csvsalesreport.common.SalesAnalysisServiceBase;
import pluralsight.testing.csvsalesreport.common.model.Sale;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

@Component
public class SalesAnalysisService implements SalesAnalysisServiceBase {

	private final CsvSalesRepository repo;

	@Autowired
	public SalesAnalysisService(CsvSalesRepository repo) {
		this.repo = repo;
	}

	public Map<String, Integer> tallySalesBy(Function<Sale, String> classifier) {
		return repo.loadSales()
				.stream()
				.collect(groupingBy(classifier,
						summingInt(Sale::getValue)));
	}

}
