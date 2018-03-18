package knightdemo.behavioral.memento;

import knightdemo.model.HolyKnight;

/**
 * @author saurabh
 * <p>
 * Implementation of holy knight with memento ability
 */
public class HolyKnightMemento extends HolyKnight implements MementoKnight {

	public Memento getMemento() {
		return new Memento(getWeapon());
	}

	public void setMemento(Memento knightMemento) {
		setWeapon(knightMemento.getWeapon());
	}

}
