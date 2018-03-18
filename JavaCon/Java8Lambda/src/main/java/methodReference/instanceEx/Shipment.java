/*
 * Copyright (c) 2018 Saurabh Kumar
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