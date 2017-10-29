package pluralsight.rxjava.observable.e_conditional;


import io.reactivex.Observable;
import pluralsight.rxjava.observable.util.DataGenerator;
import pluralsight.rxjava.observable.util.ThreadUtils;
import pluralsight.rxjava.observable.util.TimedEventSequence;

import java.util.ArrayList;
import java.util.List;

public class D_TimedConditionalExampleAmbiguous {

	public static void main(String[] args) {

		// "Ambiguous" example - First, we create two TimedEventSequence
		// instances...one that emits Greek letters with a shorter interval,
		// the other that emits English letters on a longer interval.
		TimedEventSequence<String> sequence1 = new TimedEventSequence<>(DataGenerator.generateGreekAlphabet(), 50);
		TimedEventSequence<String> sequence2 = new TimedEventSequence<>(DataGenerator.generateEnglishAlphabet(), 100);

		// Create an "ambiguous" observable from the two sequences
		List<Observable<String>> stringObservable = new ArrayList<>();
		stringObservable.add(sequence1.toObservable());
		stringObservable.add(sequence2.toObservable());

		// whichever emits first takes the subscriber - Race conditional example
		Observable.amb(stringObservable)
				.subscribe(System.out::println);

		// Start the driver thread for each of these sequences.
		sequence1.start();
		sequence2.start();

		// Wait for 4 seconds while things run...we should see Greek letters
		// being emitted at 50ms intervals for 4 seconds since the first
		// sequence to emit events will be selected by the amb operator.
		ThreadUtils.sleep(4000);

		// Stop each sequence.
		sequence1.stop();
		sequence2.stop();

		System.exit(0);
	}

}
