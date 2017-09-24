package Ch13_Java.Q13_07_Lambda_Expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
There is a class Country that has methods getContinent() and getPopulation().
Write a function int getPopulation(List<Country> countries, String continent)
that computes the total population of a given continent,
given a list of all countries and the name of a continent
 */
public class Tester {

	private static int getPopulationJava5(List<Country> countries, String continent) {
		int sum = 0;
		for (Country c : countries) {
			if (c.getContinent().equals(continent)) {
				sum += c.getPopulation();
			}
		}
		return sum;
	}

	private static int getPopulationJava8Streams(List<Country> countries, String continent) {

		Stream<Country> streamSublist = countries.stream().filter(country -> country.getContinent().equals(continent));

		//noinspection Convert2MethodRef
		Stream<Integer> populations = streamSublist.map(c -> c.getPopulation());
		//noinspection UnnecessaryLocalVariable
		int population = populations.reduce(0, (a, b) -> a + b);

		return population;
	}

	private static int getPopulationJava8Predicate(List<Country> countries, String continent) {
		Stream<Integer> populations = countries.stream()
				.map(c -> c.getContinent().equals(continent) ? c.getPopulation() : 0);

		return populations.reduce(0, (a, b) -> a + b);
	}

	public static void main(String[] args) {
		ArrayList<Country> countries = new ArrayList<>();
		countries.add(new Country("United States", "North America", 5));
		countries.add(new Country("Canada", "North America", 10));
		countries.add(new Country("India", "Asia", 30));

		String continent = "North America";
		int popA = getPopulationJava5(countries, continent);
		int popB = getPopulationJava8Streams(countries, continent);
		int popC = getPopulationJava8Predicate(countries, continent);

		if (popA == popB && popB == popC) {
			System.out.println("Population: " + popA);
		} else {
			System.out.println("Mismatch: " + popA + ", " + popB + ", " + popC);
		}
	}

}

class Country {
	private final String name;
	private final int size;
	private final String continent;

	Country(String n, String c, int sz) {
		name = n;
		size = sz;
		continent = c;
	}

	@SuppressWarnings("unused")
	String getName() {
		return name;
	}

	String getContinent() {
		return continent;
	}

	int getPopulation() {
		return size;
	}
}
