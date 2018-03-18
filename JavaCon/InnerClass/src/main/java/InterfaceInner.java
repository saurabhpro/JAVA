/*
 * Copyright (c) 2018 Saurabh Kumar
 */

/**
 * Created by Saurabh on 9/2/2015.
 */
interface Inn {
	static void show() {
		System.out.println("show");
	}

	void disp();

	class InterfaceInner {
		public static void main(String[] args) {
			System.out.println("Hello");
			Inn in = (Inn) new InterfaceInner();
			Inn inn = new InterfaceInner2();
			show();
		}
	}

	class InterfaceInner2 implements Inn {

		@Override
		public void disp() {
			System.out.println("Inside Inner class in interface");
		}
	}
}