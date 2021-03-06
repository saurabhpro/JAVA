package pluralsight.testing.csvsalesreport.guiceDI;

import pluralsight.testing.csvsalesreport.common.SalesAnalysisServiceBase;
import pluralsight.testing.csvsalesreport.common.SalesRepositoryBase;
import pluralsight.testing.csvsalesreport.common.model.Sale;

import javax.inject.Inject;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class SalesAnalysisService implements SalesAnalysisServiceBase {

	private final SalesRepositoryBase repo;

	@Inject
	public SalesAnalysisService(SalesRepositoryBase repo) {
		this.repo = repo;
	}

	public Map<String, Integer> tallySalesBy(Function<Sale, String> classifier) {
		return repo.loadSales()
				.stream()
				.collect(
						groupingBy(classifier, summingInt(Sale::getValue)));
	}

}
