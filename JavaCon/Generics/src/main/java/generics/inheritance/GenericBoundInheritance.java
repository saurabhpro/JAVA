/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package generics.inheritance;

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
	final T item;

	HoldItem(T ob) {
		item = ob;
	}

	T getItem() {
		return item;
	}
}

//extends should be followed by atmost one class and then as many interfaces as you like

/**
 * <T extends generics.inheritance.Dimension & generics.inheritance.HasColor> main reason to use extends which is different here is that
 * usually erasure removes type information when it upcast's type to Object, only methods of Object
 * since type information is lost
 * if we constrain that parameters are a subset of types we can use methods of that class
 */
class Colored<T extends Dimension & HasColor> extends HoldItem<T> {
//can only be instantiated with classes T which implement the generics.inheritance.HasColor interface AND extend generics.inheritance.Dimension class - BOTH

	Colored(T ob) {
		super(ob);      //item of super generics.inheritance.HoldItem
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
		System.out.println("generics.inheritance.Weight = " + 9);
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
		Solid<Bounded> solid = new Solid<>(new Bounded());  //generics.inheritance.Bounded is subclass of generics.inheritance.Dimension so allowed

        /*generics.inheritance.Solid<Integer> solid2 = new generics.inheritance.Solid<>(99);
        Error : type argument java.lang.Integer is not within bounds of type-variable T, Should extend generics.inheritance.Dimension
         */
		solid.color();
		solid.getY();       //ColoredDimensions
		solid.weight();     //generics.inheritance.Bounded
	}
}

