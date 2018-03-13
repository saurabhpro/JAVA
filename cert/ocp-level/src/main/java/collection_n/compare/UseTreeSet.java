package collection_n.compare;

import java.util.Set;
import java.util.TreeSet;

class Duck implements Comparable<Duck> {
	public Duck(String puddles) {
	}

	@Override
	public int compareTo(Duck o) {
		return 0;
	}
}

public class UseTreeSet {
	public static void main(String[] args) {
		Set<Duck> ducks = new TreeSet<>();
		ducks.add(new Duck("Puddles"));
		Set<Rabbit> rabbit = new TreeSet<>();
		rabbit.add(new Rabbit()); // throws an exception
	}

	static class Rabbit {
		int id;
	}
}