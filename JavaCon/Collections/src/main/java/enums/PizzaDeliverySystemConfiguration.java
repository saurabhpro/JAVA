/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package enums;

public enum PizzaDeliverySystemConfiguration {
	INSTANCE;

	private PizzaDeliveryStrategy deliveryStrategy = PizzaDeliveryStrategy.NORMAL;

	PizzaDeliverySystemConfiguration() {
		// Do the configuration initialization which
		// involves overriding defaults like delivery strategy
	}

	public static PizzaDeliverySystemConfiguration getInstance() {
		return INSTANCE;
	}

	public PizzaDeliveryStrategy getDeliveryStrategy() {
		return deliveryStrategy;
	}

}