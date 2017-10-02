package e_DependencyInversion.problem;

interface Animal {
	void speak();
}

class Cat implements Animal {

	//what we are doing here is troublesome
	//say we have a 100 class architecture and someday you implemented - BlackCatSpeaker() and want to use that instead to speak
	// so obviously you would need to come here and change this - HENCE BREAKING O-C-P
	private final CatSpeaker catSpeaker = new CatSpeaker();

	@Override
	public void speak() {
		this.catSpeaker.speak();
	}
}

class Dog implements Animal {
	//scenario 2
	// better here we are safe ?
	// um no - imagine in future Dogs get Robotic Speakers and a Robotic Speaker be assigned to Dog Speaker ?
	// no right, but if we only just used AnimalSpeaker Interface -> any subclass can be assigned to it
	// hence ALWAYS RELAY ON Abstractions
	private final DogSpeaker dogSpeaker;


	// we are injecting our speaker here - AWESOME!!!
	public Dog(DogSpeaker dogSpeaker) {
		this.dogSpeaker = dogSpeaker;
	}

	@Override
	public void speak() {
		this.dogSpeaker.speak();
	}
}

class Cow implements Animal {

	//scenario 3
	// what now :X
	// we have duplication in every method - > why do we need these special Animal objects if all we care about is there speak
	// see the solution package for full awesomeness
	private final AnimalSpeaker animalSpeaker;

	public Cow(AnimalSpeaker animalSpeaker) {
		this.animalSpeaker = animalSpeaker;
	}

	@Override
	public void speak() {
		this.animalSpeaker.speak();
	}
}