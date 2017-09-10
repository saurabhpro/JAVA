package behavioral.mediator;

import model.Knight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author saurabh
 *         <p>
 *         Central point where Knight can send a quest to other knight, all
 *         knights have reference to this central point ( mediator)
 */
public class MedevilPostOffice {

	private Map<Integer, Knight> medevilAddressBook = new HashMap<>();

	public void addToAddressBook(Integer palaceNumber, Knight knight) {
		medevilAddressBook.put(palaceNumber, knight);
	}

	public void sendQuest(Integer palaceNumber, String questDetails) {
		medevilAddressBook.get(palaceNumber).readQuest(questDetails);
	}

}
