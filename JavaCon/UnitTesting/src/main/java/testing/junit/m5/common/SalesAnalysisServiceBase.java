package testing.junit.m5.common;

import java.util.Map;
import java.util.function.Function;

/**
 * Created by saurabhkumar on 21/05/17.
 */
public interface SalesAnalysisServiceBase {

	default Map<String, Integer> tallyProductSales() {
		return tallySalesBy(Sale::getProduct);
	}

	default Map<String, Integer> tallyStoreSales() {
		return tallySalesBy(Sale::getStore);
	}

	Map<String, Integer> tallySalesBy(Function<Sale, String> classifier);
}
