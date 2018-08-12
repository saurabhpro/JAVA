package knightdemo.creational.abstractfactory;

import knightdemo.model.Knight;
import knightdemo.model.MajesticKnight;

/**
 * @author saurabh
 */
public class MajesticFactory implements Factory {

    public Knight getKnight() {
        return new MajesticKnight();
    }
}
