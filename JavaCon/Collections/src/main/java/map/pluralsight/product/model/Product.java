/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package map.pluralsight.product.model;

import java.util.Comparator;
import java.util.Objects;

import static java.util.Comparator.comparing;

public class Product {

	public static final Comparator<Product> BY_NAME = comparing(Product::getName);

	public static final Comparator<Product> BY_WEIGHT = comparing(Product::getWeight);

	private final int id;
	private final String name;
	private final int weight;

	public Product(final int id, final String name, final int weight) {
		this.id = id;
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", weight=" + weight +
				'}';
	}

	public boolean equals(final Object o) {
		if (!(o instanceof Product)) return false;

		final Product product = (Product) o;

		return Objects.equals(id, product.id)
				&& Objects.equals(weight, product.weight)
				&& Objects.equals(name, product.name);
	}

	public int hashCode() {
		return Objects.hash(id, name, weight);
	}
}
