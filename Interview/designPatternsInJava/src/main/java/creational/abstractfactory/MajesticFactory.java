package creational.abstractfactory;

import model.Knight;
import model.MajesticKnight;

/**
 * @author saurabh
 */
public class MajesticFactory implements Factory {

	public Knight getKnight() {
		return new MajesticKnight();
	}
}
