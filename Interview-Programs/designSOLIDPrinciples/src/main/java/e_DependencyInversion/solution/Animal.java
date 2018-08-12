package e_DependencyInversion.solution;

import e_DependencyInversion.problem.AnimalSpeaker;

class Animal {

    private final AnimalSpeaker animalSpeaker;

    public Animal(AnimalSpeaker animalSpeaker) {
        this.animalSpeaker = animalSpeaker;
    }

    public void speak() {
        this.animalSpeaker.speak();
    }
}
