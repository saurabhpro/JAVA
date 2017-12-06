package references;

// typical overriding problem
class Bird {

	String n1 = "hi";

	public String getName() {
		return "Unknown";
	}

	public void displayInformation() {
		System.out.println("The bird name is: " + getName());
	}
}

class Peacock extends Bird {

	String n1 = "hello";

	public static void main(String[] args) {

		Bird bird = new Peacock();
		bird = new Bird();

		System.out.println(bird + " " + bird.hashCode());

		bird.displayInformation();

		// what about if i do this and want to print value of n1
		bird = new Peacock();
		System.out.println(bird.n1);        // prints hi since veriabled don't tak part in polymorphism
	}


//	Peacock(){
//		this(6);
//	}
//
//	Peacock(int d){
//		this();
//	} compile time error

	public String getName() {
		return "Peacock";
	}

}