package testing.junit.m5.after_refactor;

import testing.junit.m5.common.Sale;
import testing.junit.m5.common.SalesAnalysisServiceBase;
import testing.junit.m5.common.SalesRepositoryBase;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class SalesAnalysisService implements SalesAnalysisServiceBase {

	private final SalesRepositoryBase repo;

	public SalesAnalysisService(SalesRepositoryBase repo) {
		this.repo = repo;
	}

	public Map<String, Integer> tallySalesBy(Function<Sale, String> classifier) {
		return repo.loadSales()
				.stream()
				.collect(groupingBy(classifier,
						summingInt(Sale::getValue)));
	}

}
