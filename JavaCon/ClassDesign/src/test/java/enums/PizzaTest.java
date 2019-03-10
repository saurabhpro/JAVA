/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package enums;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PizzaTest {
	@Test
	public void givenPizzaOrders_whenRetrievingUnDeliveredPzs_thenCorrectlyRetrieved() {

		// given
		List<Pizza> pzList = getPizzasList();

		// when
		List<Pizza> undeliveredPzs = Pizza.getAllUndeliveredPizzas(pzList);

		// then
		assertEquals(3, undeliveredPzs.size());
	}


	@Test
	public void givenPizzaOrders_whenGroupByStatusCalled_thenCorrectlyGrouped() {
		List<Pizza> pzList = getPizzasList();

		EnumMap<Pizza.PizzaStatusEnum, List<Pizza>> map = Pizza.groupPizzaByStatus(pzList);

		assertEquals(1, map.get(Pizza.PizzaStatusEnum.DELIVERED).size());
		assertEquals(2, map.get(Pizza.PizzaStatusEnum.ORDERED).size());
		assertEquals(1, map.get(Pizza.PizzaStatusEnum.READY).size());
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