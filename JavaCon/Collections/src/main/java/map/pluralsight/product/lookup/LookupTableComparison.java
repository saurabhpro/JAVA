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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LookupTableComparison {
	private static final int ITERATIONS = 5;
	private static final int NUMBER_OF_PRODUCTS = 20_000;

	private static final List<Product> products = generateProducts();

	public static void main(String[] args) {
		runLookups(new MapProductLookupTable());
		runLookups(new NaiveProductLookupTable());
	}

	private static List<Product> generateProducts() {
		final List<Product> products = new ArrayList<>();
		final Random weightGenerator = new Random();
		for (int i = 0; i < NUMBER_OF_PRODUCTS; i++) {
			products.add(new Product(i, "Product" + i, 10 + weightGenerator.nextInt(10)));
		}
		Collections.shuffle(products);
		Collections.shuffle(products);
		Collections.shuffle(products);
		return products;
	}

	private static void runLookups(final ProductLookupTable lookupTable) {
		final List<Product> products = LookupTableComparison.products;
		System.out.println("Running lookups with " + lookupTable.getClass().getSimpleName());

		for (int i = 0; i < ITERATIONS; i++) {
			final long startTime = System.currentTimeMillis();

			for (Product product : products) {
				lookupTable.addProduct(product);
			}

			for (Product product : products) {
				final Product result = lookupTable.lookupById(product.getId());
				if (result != product) {
					throw new IllegalStateException("Lookup Table returned wrong result for " + product);
				}
			}

			lookupTable.clear();

			System.out.println(System.currentTimeMillis() - startTime + "ms");
		}
	}
}
