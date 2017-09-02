package pluralsight.testing.csvsalesreport.common;

import pluralsight.testing.csvsalesreport.common.model.Sale;

import java.util.Map;
import java.util.function.Function;

public interface SalesAnalysisServiceBase {

	default Map<String, Integer> tallyProductSales() {
		return tallySalesBy(Sale::getProduct);
	}

	default Map<String, Integer> tallyStoreSales() {
		return tallySalesBy(Sale::getStore);
	}

	Map<String, Integer> tallySalesBy(Function<Sale, String> classifier);
}
