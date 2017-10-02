package e_DependencyInversion.problem;

public class DIAnimalSpeakers {
	public static void main(String[] args) {
		Animal cat = new Cat();
		cat.speak();        //fine

		Animal dog = new Dog(new DogSpeaker());
		dog.speak();        //good

		Animal cow = new Cow(new CowSpeaker());
		cow.speak();        //BETTER
	}
}
