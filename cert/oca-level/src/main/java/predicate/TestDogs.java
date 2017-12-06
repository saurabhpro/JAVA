package predicate;


import java.util.ArrayList;
import java.util.function.Predicate;

public class TestDogs {
	public static void main(String[] args) {
		ArrayList<Dog> listOfDogs = new ArrayList<>();
		listOfDogs.add(new Dog("Will", 7, 22));
		listOfDogs.add(new Dog("Max", 2, 3));
		listOfDogs.add(new Dog("Ron", 12, 18));
		listOfDogs.add(new Dog("Ruptr", 5, 8));
		listOfDogs.add(new Dog("Cory", 6, 19));

		System.out.println("all dogs " + listOfDogs);

		System.out.println("min age 7 " + checkForMinAge(listOfDogs, 7));
		System.out.println("max weight 18 " + checkForMaxWeight(listOfDogs, 18));

		System.out.println("min age 7  " + dogQuery(listOfDogs, d -> d.getAge() >= 7));
		System.out.println("max weight 18 " + dogQuery(listOfDogs, d -> d.getWeight() <= 18));
	}


	private static ArrayList<Dog> checkForMinAge(ArrayList<Dog> listOfDogs, int ageLimit) {

		ArrayList<Dog> temp = new ArrayList<>();
		for (Dog d : listOfDogs) {
			// check
			if (d.getAge() >= ageLimit) {
				temp.add(d);
			}
		}

		return temp;
	}


	private static ArrayList<Dog> dogQuery(ArrayList<Dog> listOfDogs, Predicate<Dog> qry) {
		ArrayList<Dog> temp = new ArrayList<>();
		for (Dog d : listOfDogs) {
			// check query
			if (qry.test(d)) {
				temp.add(d);
			}
		}

		return temp;
	}


	private static ArrayList<Dog> checkForMaxWeight(ArrayList<Dog> listOfDogs, int wightLimit) {
		ArrayList<Dog> temp = new ArrayList<>();
		for (Dog d : listOfDogs) {
			// check
			if (d.getWeight() <= wightLimit) {
				temp.add(d);
			}
		}

		return temp;
	}

	// so wouldn't it be cool if we can pass the comparision conditions as arguments,
	// in that way both the above methods will be same
}
