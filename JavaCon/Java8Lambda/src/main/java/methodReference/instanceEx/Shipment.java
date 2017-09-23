/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package methodReference.instanceEx;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by saurabhkumar on 23/05/17.
 */
class Shipment {
	public static void main(String[] args) {
		Shipment ship = new Shipment();
		List<Shipment> l = new ArrayList<>();

		// Using an anonymous class
		//noinspection Convert2Lambda
		ship.calculateOnShipments(l, new Function<>() {
			public Double apply(Shipment s) { // The object
				return s.calculateWeight(); // The method
			}
		});

		// Using a lambda expression
		ship.calculateOnShipments(l, s -> s.calculateWeight());

		// Using a method reference
		ship.calculateOnShipments(l, Shipment::calculateWeight);
	}

	private double calculateWeight() {
		double weight = 0;
		// Calculate weight
		return weight;
	}

	private List<Double> calculateOnShipments(List<Shipment> l, Function<Shipment, Double> f) {
		List<Double> results = new ArrayList<>();
		for (Shipment s : l) {
			results.add(f.apply(s));
		}
		return results;
	}
}