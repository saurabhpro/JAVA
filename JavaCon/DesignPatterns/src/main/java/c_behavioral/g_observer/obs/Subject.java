package c_behavioral.g_observer.obs;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

	private final List<Observer> observers = new ArrayList<>();

	abstract String getState();

	abstract void setState(String state);

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void detach(Observer observer) {
		observers.remove(observer);
	}

	void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
