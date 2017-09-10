package creational.prototype;

import model.Knight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author saurabh
 */
public class PrototypeFactory {

	//holds map of prototypes
	private static Map<String, Knight> prototypes = new HashMap<>();

	/**
	 * Adds prototype in the prototype map
	 *
	 * @param key
	 * @param knight
	 */
	public static void addPrototype(String key, Knight knight) {
		prototypes.put(key, knight);
	}

	/**
	 * Retrieves the prototype based on the prototype key
	 *
	 * @param key
	 * @return Knight
	 */
	public Knight getPrototype(String key) {
		if (!prototypes.containsKey(key)) {
			throw new RuntimeException("Knight missing!");
		}

		try {
			return prototypes.get(key).cloneKnight();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Cloning failed.");
		}
	}

}
