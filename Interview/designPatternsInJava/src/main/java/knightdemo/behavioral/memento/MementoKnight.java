package knightdemo.behavioral.memento;

import knightdemo.model.Knight;

/**
 * @author saurabh
 *         <p>
 *         Knight with extra ability to create a memento and receive one
 */
public interface MementoKnight extends Knight {

	Memento getMemento();

	void setMemento(Memento knightMemento);

}
