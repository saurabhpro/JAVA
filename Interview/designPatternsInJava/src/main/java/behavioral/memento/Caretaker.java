package behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saurabh
 *         <p>
 *         Caretaker holds mementos and allows user to save and reach for it when it is required
 */
public class Caretaker {

	private List<Memento> pointsInHistory = new ArrayList<>();

	public void addMemento(Memento memento) {
		pointsInHistory.add(memento);
	}

	public Memento getMemento(Integer location) {
		if (location < 0 || location > pointsInHistory.size()) {
			return null;
		}
		return pointsInHistory.get(location);
	}

}
