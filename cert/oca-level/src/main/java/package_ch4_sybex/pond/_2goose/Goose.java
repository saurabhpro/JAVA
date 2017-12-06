package package_ch4_sybex.pond._2goose;

import package_ch4_sybex.pond._1shore.Bird;

public class Goose extends Bird {

	public void swim() {
		floatInWater(); // package access to superclass
		System.out.println(text); // package access to superclass
	}

	public void helpGooseSwim() {
		Goose other = new Goose();
		other.floatInWater();
		System.out.println(other.text);
	}

	public void helpOtherBirdSwim() {
		Bird other = new Bird();

		//other.floatInWater(); // DOES NOT COMPILE
		//System.out.println(other.text); // DOES NOT COMPILE
	}

	public void helpOtherGooseSwim() {
		Bird other = new Goose();
		// remember Goose() is stored as Reference of Bird which is different package hence no access to the methods

		//other.floatInWater(); // DOES NOT COMPILE
		//System.out.println(other.text); // DOES NOT COMPILE
	}
}