package b_structural.f_flyweight;

public class Order {
	private final int orderNumber;
	private final Item item;

	Order(int orderNumber, Item item) {
		this.orderNumber = orderNumber;
		this.item = item;
	}

	void processOrder() {
		System.out.println("Ordering " + item + " for parts number " + orderNumber);
	}
}