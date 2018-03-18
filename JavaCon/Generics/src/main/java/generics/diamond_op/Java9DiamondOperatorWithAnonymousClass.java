/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package generics.diamond_op;

public class Java9DiamondOperatorWithAnonymousClass {
	public static void main(String[] args) {

		//Java 8 way
		//noinspection Convert2Diamond
		MyHandler<Integer> intHandler0 = new MyHandler<Integer>(0) {

			public void handle() {
				// handling code...
			}
		};
		intHandler0.handle();

		//from Java 9 we can use <> to infer the type
		MyHandler<Integer> intHandler = new MyHandler<>(1) {

			@Override
			public void handle() {
				System.out.println("handle > " + this.getContent());    //this here mean the context of anonymous class
			}
		};

		intHandler.handle();

		MyHandler<? extends Integer> intHandler1 = new MyHandler<>(10) {

			@Override
			void handle() {
				System.out.println("handle > " + getContent());
			}
		};

		intHandler1.handle();

		MyHandler<?> handler = new MyHandler<>("One hundred") {

			@Override
			void handle() {
				System.out.println("handle > " + getContent());
			}
		};

		handler.handle();
	}
}
