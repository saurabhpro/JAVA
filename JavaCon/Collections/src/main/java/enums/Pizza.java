/*
 * Copyright 2018 Saurabh Kumar 17/3/18 10:19 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package enums;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza {

	private static EnumSet<PizzaStatusEnum> deliveredPizzaStatuses = EnumSet.of(PizzaStatusEnum.DELIVERED);

	private PizzaStatusEnum status;

	public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) {
		return input.stream().filter((s) -> !deliveredPizzaStatuses.contains(s.getStatus())).collect(Collectors.toList());
	}

	public static EnumMap<PizzaStatusEnum, List<Pizza>> groupPizzaByStatus(List<Pizza> pzList) {
		return pzList.stream().collect(Collectors.groupingBy(Pizza::getStatus, () -> new EnumMap<>(PizzaStatusEnum.class), Collectors.toList()));
	}

	public PizzaStatusEnum getStatus() {
		return status;
	}

	public void setStatus(PizzaStatusEnum status) {
		this.status = status;
	}

	public boolean isDeliverable() {
		return this.status.isReady();
	}

	public void printTimeToDeliver() {
		System.out.println("Time to delivery is " + this.getStatus().getTimeToDelivery() + " days");
	}

	public void deliver() {
		if (isDeliverable()) {
			PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy().deliver(this);
			this.setStatus(PizzaStatusEnum.DELIVERED);
		}
	}

	public enum PizzaStatusEnum {
		ORDERED(5) {
			@Override
			public boolean isOrdered() {
				return true;
			}
		},
		READY(2) {
			@Override
			public boolean isReady() {
				return true;
			}
		},
		DELIVERED(0) {
			@Override
			public boolean isDelivered() {
				return true;
			}
		};

		private int timeToDelivery;

		PizzaStatusEnum(int timeToDelivery) {
			this.timeToDelivery = timeToDelivery;
		}

		public boolean isOrdered() {
			return false;
		}

		public boolean isReady() {
			return false;
		}

		public boolean isDelivered() {
			return false;
		}

		public int getTimeToDelivery() {
			return timeToDelivery;
		}
	}

}