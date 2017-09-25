package knightdemo.behavioral.observer;

import knightdemo.model.Knight;

/**
 * @author saurabh
 */
public class ArmorObserver implements Observer {

	private Knight knight;

	public ArmorObserver(Knight knight) {
		this.knight = knight;
	}

	public void update() {
		System.out.println("Observer : Update armor UI " + knight.getArmor());
	}
}
