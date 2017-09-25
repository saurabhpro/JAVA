package knightdemo.structural.proxy;

import knightdemo.model.Knight;

public class Main {

	public static void main(String[] args) {
		Knight knightProxy = new MajesticKnightProxy();
		System.out.println("Initialize...");
		System.out.println("____");
		System.out.println(knightProxy.getName());

		// Initialize...
		// ____
		// On Request knight creation ...
		// Majestic is my fathers name and so is mine!
	}

}
