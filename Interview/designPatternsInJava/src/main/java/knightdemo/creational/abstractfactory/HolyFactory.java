package knightdemo.creational.abstractfactory;

import knightdemo.model.HolyKnight;
import knightdemo.model.Knight;

/**
 * @author saurabh
 */
public class HolyFactory implements Factory {

	public Knight getKnight() {
		return new HolyKnight();
	}
}
