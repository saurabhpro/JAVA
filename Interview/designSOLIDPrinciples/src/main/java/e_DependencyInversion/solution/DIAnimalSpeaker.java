package e_DependencyInversion.solution;

import e_DependencyInversion.problem.AnimalSpeaker;

public class DIAnimalSpeaker {
	public static void main(String[] args) {
		Animal cat = new Animal(new CatSpeaker());
		cat.speak();        //fine

		Animal dog = new Animal(new DogSpeaker());
		dog.speak();        //good

		Animal cow = new Animal(new CowSpeaker());
		cow.speak();        //BETTER
	}
}

class CatSpeaker implements AnimalSpeaker {

	@Override
	public void speak() {
		System.out.println("Meowww");
	}
}


class DogSpeaker implements AnimalSpeaker {

	@Override
	public void speak() {
		System.out.println("Bhawww ");
	}
}


class CowSpeaker implements AnimalSpeaker {

	@Override
	public void speak() {
		System.out.println("Muuuuu");
	}
}
