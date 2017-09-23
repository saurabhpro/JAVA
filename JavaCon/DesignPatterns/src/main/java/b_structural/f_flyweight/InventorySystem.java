/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package b_structural.f_flyweight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class InventorySystem {

	private final Catalog catalog = new Catalog();
	private final List<Order> orders = new CopyOnWriteArrayList<>();

	void takeOrder(String itemName, int orderNumber) {
		Item item = catalog.lookup(itemName);
		Order order = new Order(orderNumber, item);
		orders.add(order);
	}

	void process() {
		for (Order order : orders) {
			order.processOrder();
			orders.remove(order);
		}
	}

	String report() {
		return "\nTotal Item objects made: "
				+ catalog.totalItemsMade();
	}
}