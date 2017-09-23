package map.pluralsight.product.lookup;

import map.pluralsight.product.model.Product;

interface ProductLookupTable {
	Product lookupById(int id);

	void addProduct(Product productToAdd);

	void clear();
}
