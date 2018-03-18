/*
 * Copyright (c) 2018 Saurabh Kumar
 */

/**
 * Created by Saurabh on 2/21/2016.
 */

class Simple {
	void message() {
		System.out.println("Hello Java");
	}
}

public class CallPrivateOfOtherClass {
	public static void main(String args[]) {
		try {
			Class<?> c = Class.forName(Simple.class.getName());

			//Simple s = (Simple) c.newInstance();
			//updated by jdk9
			Simple s = (Simple) c.getDeclaredConstructor().newInstance();

			s.message();

		} catch (Exception e) {
			System.out.println(e + "hello");
		}

	}
}
