/*
 * Copyright (c) 2018 Saurabh Kumar
 */

/**
 * Created by Saurabh on 2/21/2016.
 */

class Ax1 {
}

class Bx1 extends Ax1 {
}

class Cx1 extends Bx1 {
}

public class GetSuper {

	public static void main(String[] args) {
		new GetSuper().show(new Cx1());
	}

	private void show(Object object) {
		Class subclass = object.getClass();
		System.out.println(subclass);
		Class superClass = subclass.getSuperclass();
		if (superClass != null) {
			System.out.println("super class " + superClass);

			System.out.println("getSuper " + subclass.isArray());
			System.out.println("superclass name " + superClass.getName());
		}
	}
}
