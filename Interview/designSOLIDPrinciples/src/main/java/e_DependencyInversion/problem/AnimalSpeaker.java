package e_DependencyInversion.problem;

public interface AnimalSpeaker {
	void speak();
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
