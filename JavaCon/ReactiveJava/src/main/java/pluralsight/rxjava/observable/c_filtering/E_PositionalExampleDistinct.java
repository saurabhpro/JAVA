/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.c_filtering;

import io.reactivex.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

public class E_PositionalExampleDistinct {

	public static void main(String[] args) {

		Observable.fromIterable(DataGenerator.generateScrambledAndDuppedGreekAlphabet())
				.count()
				.subscribe((letter) -> {
					System.out.println(letter);
				})
				.dispose();

		System.out.println("------------------------------------------------------------");

		// Emit each string value only once, even if it appears in the
		// original list multiple times.
		Observable.fromIterable(DataGenerator.generateScrambledAndDuppedGreekAlphabet())
				.distinct()
				.count()
				.subscribe((letter) -> {
					System.out.println(letter);
				})
				.dispose();

		System.out.println("------------------------------------------------------------");

		//System.exit(0);
	}
}
