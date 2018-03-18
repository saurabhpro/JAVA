/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.d_transformation;

import io.reactivex.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;

public class B_ScanExample {

	public static void main(String[] args) {

		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.scan(new StringBuilder(), /*data for onNext call*/(accumBuffer, nextLetter) -> accumBuffer.append(nextLetter))
				// called for every scan item
				.subscribe((total) -> {

					System.out.println("Scan Event: " + total.toString());
				});

		System.out.println("--------------------------------------------------");

		Observable.fromIterable(DataGenerator.generateGreekAlphabet())
				.scan(new StringBuilder(), (accumBuffer, nextLetter) -> accumBuffer.append(nextLetter))
				.lastOrError()
				.subscribe((total) -> {
					System.out.println("Scan Event: " + total.toString());
				});

		System.out.println("--------------------------------------------------");

		System.exit(0);
	}
}
