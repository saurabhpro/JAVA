package knightdemo.behavioral.observer;

import knightdemo.model.HolyKnight;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saurabh
 * <p>
 * Implementation of observer knight, it calls all observers when armor is reduced
 */
public class ObserverHolyKnight extends HolyKnight implements KnightObserver {

	private List<Observer> observers = new ArrayList<>();

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void update() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	@Override
	public void reduceArmor(Double reduceValue) {
		super.reduceArmor(reduceValue);
		update();
	}

}
