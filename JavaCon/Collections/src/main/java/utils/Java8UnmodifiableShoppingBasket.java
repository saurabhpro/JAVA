/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package utils;

import map.pluralsight.product.model.Product;
import map.pluralsight.product.model.ProductFixtures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by saurabhkumar on 20/05/17.
 */
public class Java8UnmodifiableShoppingBasket {
	private final List<Product> items = new ArrayList<>();
	private int totalWeight;

	public static void main(String[] args) {
		Java8UnmodifiableShoppingBasket shoppingBasket = new Java8UnmodifiableShoppingBasket();

		shoppingBasket.addMyProduct(ProductFixtures.floorPanel);
		System.out.println(shoppingBasket);

		shoppingBasket.getItems().add(ProductFixtures.door);
		//only view is unmodifiable, you can always addMyProduct() as ArrayList is mutable
		System.out.println(shoppingBasket); //Exception
	}

	private void addMyProduct(Product newItem) {
		items.add(newItem);
		totalWeight += newItem.getWeight();
	}

	private List<Product> getItems() {
		//return  items;

		return Collections.unmodifiableList(items);     //fail fast exception is tried to modify this list
	}

	@Override
	public String toString() {
		return "Shoping basket of " + items + " with wright = " + totalWeight;
	}
}
