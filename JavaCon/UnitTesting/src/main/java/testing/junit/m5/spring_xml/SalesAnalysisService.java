package testing.junit.m5.spring_xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testing.junit.m5.common.Sale;
import testing.junit.m5.common.SalesAnalysisServiceBase;

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
