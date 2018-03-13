package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Car {
	private String model;
	private int year;

	public Car(String name, int year) {
		this.model = name;
		this.year = year;
	}

	public static void main(String... make) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Mustang", 1967));
		cars.add(new Car("Thunderbird", 1967));
		cars.add(new Car("Escort", 1975));

		ConcurrentMap<Integer, List<Car>> map = cars
				.stream()
				.collect(Collectors.groupingByConcurrent(Car::getYear));

		System.out.print(map);
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return model;
	}
}