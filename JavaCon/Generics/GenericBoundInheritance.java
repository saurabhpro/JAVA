/**
 * Created by Saurabh on 8/12/2015.
 */

interface HasColor {
    java.awt.Color getColor();
}

interface Weight {
    int weight();
}

class Dimension {
    public int x, y, z;
}

class HoldItem<T> {
    T item;

    HoldItem(T ob) {
        item = ob;
    }

    T getItem() {
        return item;
    }
}

//extends should be followed by atmost one class and then as many interfaces as you like

/**
 * <T extends Dimension & HasColor> main reason to use extends which is different here is that
 * usually erasure removes type information when it upcast's type to Object, only methods of Object
 * since type information is lost
 * if we constrain that parameters are a subset of types we can use methods of that class
 */
class Colored<T extends Dimension & HasColor> extends HoldItem<T> {
//can only be instantiated with classes T which implement the HasColor interface AND extend Dimension class - BOTH

    Colored(T ob) {
        super(ob);      //item of super HoldItem
    }

    java.awt.Color color() {
        return item.getColor();
    }
}

class ColoredDimension<T extends Dimension & HasColor> extends Colored<T> {

    ColoredDimension(T ob) {
        super(ob);
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }

}

class Bounded extends Dimension implements HasColor, Weight {
    @Override
    public java.awt.Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        System.out.println("Weight = " + 9);
        return 0;
    }
}

class Solid<T extends Dimension & HasColor & Weight> extends ColoredDimension<T> {
    Solid(T ob) {
        super(ob);
    }

    int weight() {
        return item.weight();
    }

}

public class GenericBoundInheritance {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());  //Bounded is subclass of Dimension so allowed

        /*Solid<Integer> solid2 = new Solid<>(99);
        Error : type argument java.lang.Integer is not within bounds of type-variable T, Should extend Dimension
         */
        solid.color();
        solid.getY();       //ColoredDimensions
        solid.weight();     //Bounded
    }
}

