package Ch03_Stacks_and_Queues.Q3_06_Animal_Shelter;

public abstract class Animal {
	final String name;
	private int order;

	Animal(String n) {
		name = n;
	}

	public abstract String name();

	private int getOrder() {
		return order;
	}

	public void setOrder(int ord) {
		order = ord;
	}

	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
}
