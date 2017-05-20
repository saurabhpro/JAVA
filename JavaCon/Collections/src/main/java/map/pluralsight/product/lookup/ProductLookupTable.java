package map.pluralsight.product.lookup;

import map.pluralsight.product.model.Product;

public interface ProductLookupTable {
	Product lookupById(int id);

	void addProduct(Product productToAdd);

	void clear();
}
