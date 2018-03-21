/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package enums;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


class PizzaTest {
	@Test
	public void givenPizzaOrders_whenRetrievingUnDeliveredPzs_thenCorrectlyRetrieved() {

		// given
		List<Pizza> pzList = getPizzasList();

		// when
		List<Pizza> undeliveredPzs = Pizza.getAllUndeliveredPizzas(pzList);

		// then
		assertTrue(undeliveredPzs.size() == 3);
	}


	@Test
	public void givenPizzaOrders_whenGroupByStatusCalled_thenCorrectlyGrouped() {
		List<Pizza> pzList = getPizzasList();

		EnumMap<Pizza.PizzaStatusEnum, List<Pizza>> map = Pizza.groupPizzaByStatus(pzList);

		assertTrue(map.get(Pizza.PizzaStatusEnum.DELIVERED).size() == 1);
		assertTrue(map.get(Pizza.PizzaStatusEnum.ORDERED).size() == 2);
		assertTrue(map.get(Pizza.PizzaStatusEnum.READY).size() == 1);
	}

	@NotNull
	private List<Pizza> getPizzasList() {
		List<Pizza> pzList = new ArrayList<>();

		Pizza pz1 = new Pizza();
		pz1.setStatus(Pizza.PizzaStatusEnum.DELIVERED);

		Pizza pz2 = new Pizza();
		pz2.setStatus(Pizza.PizzaStatusEnum.ORDERED);

		Pizza pz3 = new Pizza();
		pz3.setStatus(Pizza.PizzaStatusEnum.ORDERED);

		Pizza pz4 = new Pizza();
		pz4.setStatus(Pizza.PizzaStatusEnum.READY);

		pzList.add(pz1);
		pzList.add(pz2);
		pzList.add(pz3);
		pzList.add(pz4);
		return pzList;
	}

}