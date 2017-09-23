/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package map.pluralsight.product;

import map.pluralsight.product.model.Product;
import map.pluralsight.product.model.ProductFixtures;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ViewsOverMaps {
	public static void main(String[] args) {
		final Map<Integer, Product> idToProduct = new HashMap<>();
		idToProduct.put(1, ProductFixtures.door);
		idToProduct.put(2, ProductFixtures.floorPanel);
		idToProduct.put(3, ProductFixtures.window);

		System.out.println(idToProduct);
		System.out.println();

		final Set<Integer> ids = idToProduct.keySet();
		System.out.println(ids);
		System.out.println();

		ids.remove(1);
		System.out.println(ids);
		System.out.println(idToProduct);
		System.out.println();

		// ids.add(1);

		final Collection<Product> products = idToProduct.values();
		System.out.println(products);
		System.out.println();

		products.remove(ProductFixtures.floorPanel);
		System.out.println(products);
		System.out.println(idToProduct);
		System.out.println();

		// products.add(ProductFixtures.floorPanel);

		final Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet();
		for (Map.Entry<Integer, Product> entry : entries) {
			System.out.println(entry);
		}

		idToProduct.forEach((key, value) -> System.out.println(key + " -> " + value));
	}
}
