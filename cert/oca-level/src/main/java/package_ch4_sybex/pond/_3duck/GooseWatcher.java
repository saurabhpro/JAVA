package package_ch4_sybex.pond._3duck;

import package_ch4_sybex.pond._2goose.Goose;

public class GooseWatcher {

	public void watch() {
		Goose goose = new Goose();
		//goose.floatInWater();  // goose indeed had this method from inheritance - but it was protected in its package
	}
}