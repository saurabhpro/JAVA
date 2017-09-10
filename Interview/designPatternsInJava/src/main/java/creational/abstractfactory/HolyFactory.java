package creational.abstractfactory;

import model.HolyKnight;
import model.Knight;

/**
 * @author saurabh
 */
public class HolyFactory implements Factory {

	public Knight getKnight() {
		return new HolyKnight();
	}
}
