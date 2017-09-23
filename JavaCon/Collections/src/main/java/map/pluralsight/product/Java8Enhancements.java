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

import java.util.HashMap;
import java.util.Map;

public class Java8Enhancements {
	public static void main(String[] args) {
		final Product defaultProduct = new Product(-1, "Whatever the customer wants", 100);

		final Map<Integer, Product> idToProduct = new HashMap<>();
		idToProduct.put(1, ProductFixtures.door);
		idToProduct.put(2, ProductFixtures.floorPanel);
		idToProduct.put(3, ProductFixtures.window);

		Product result = idToProduct.getOrDefault(10, defaultProduct);
		System.out.println(result);
		System.out.println(idToProduct.get(10));
		System.out.println();

		result = idToProduct
				.computeIfAbsent(10, (id) -> new Product(id, "Custom Product", 10));
		System.out.println(result);
		System.out.println(idToProduct.get(10));
		System.out.println();

		result = idToProduct.replace(1, new Product(1, "Big Door", 50));
		System.out.println(result);
		System.out.println(idToProduct.get(1));
		System.out.println();

		idToProduct.replaceAll((key, oldProduct) ->
				new Product(oldProduct.getId(), oldProduct.getName(), oldProduct.getWeight() + 10));
		System.out.println(idToProduct);
		System.out.println();

		idToProduct.forEach((key, value) -> System.out.println(key + " -> " + value));
	}
}
