/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package map.pluralsight.product.lookup;

import map.pluralsight.product.model.Product;

import java.util.HashMap;
import java.util.Map;

public class MapProductLookupTable implements ProductLookupTable {
	private final Map<Integer, Product> idToProduct = new HashMap<>();

	@Override
	public void addProduct(final Product productToAdd) {
		final int id = productToAdd.getId();
		if (idToProduct.containsKey(id)) {
			throw new IllegalArgumentException(
					"Unable to add product, duplicate id for: " + productToAdd);
		}

		idToProduct.put(id, productToAdd);
	}

	@Override
	public Product lookupById(final int id) {
		return idToProduct.get(id);
	}

	public void clear() {
		idToProduct.clear();
	}
}
