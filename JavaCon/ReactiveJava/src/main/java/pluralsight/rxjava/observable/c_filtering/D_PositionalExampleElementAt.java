/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.c_filtering;


import io.reactivex.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

/**
 * when we know where elements at
 */
public class D_PositionalExampleElementAt {

	public static void main(String[] args) {

		// Emit the 3rd letter in the greek alphabet
		// Gamma
		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.elementAt(2)
				.subscribe((letter) -> {
					System.out.println(letter);
				});

		System.out.println();

		// Emit the 50th letter in the greek alphabet
		// ...there isn't a 50th letter, so we want to get "Unknown"
		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.elementAt(50, "Unknown")
				.subscribe((letter) -> {
					System.out.println(letter);
				});

		System.out.println();


		System.exit(0);
	}
}
