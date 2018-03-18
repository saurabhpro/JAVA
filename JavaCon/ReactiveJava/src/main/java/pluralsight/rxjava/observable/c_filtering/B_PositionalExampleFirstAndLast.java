/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.c_filtering;

import io.reactivex.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

public class B_PositionalExampleFirstAndLast {

	public static void main(String[] args) {

		// Emit the greek alphabet, but only the first letter
		// Alpha
		System.out.println("Get First: ");
		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.first("Default if empty")  //first now take a mandatory item for default
				.subscribe(System.out::println);

		System.out.println();

		// Emit the greek alphabet, but only the first 4
		// Alpha, Beta, Gamma, Delta
		System.out.println("Get First 4: ");
		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.take(4)
				.subscribe(System.out::println);

		System.out.println();

		// Emit the greek alphabet, but only the last letter
		// Omega
		System.out.println("Get Last: ");
		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.last("Default if empty")   // last needs a default to be passed now
				.subscribe(System.out::println);

		System.out.println();

		// Emit the greek alphabet, but this time only the last 4
		// Phi, Chi, Psi, Omeaga
		System.out.println("Get Last 4: ");
		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.takeLast(4)
				.subscribe(System.out::println);

		System.out.println();

		// firstOrDefault and lastOrDefault allows you to handle the case where there is
		// an empty list.
		Observable.empty()
				.first("List is empty!")
				.subscribe(System.out::println);

		Observable.empty()
				.last("List is empty!")
				.subscribe(System.out::println);

		System.exit(0);
	}
}
