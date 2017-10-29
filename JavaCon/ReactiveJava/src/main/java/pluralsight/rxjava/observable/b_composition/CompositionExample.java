/*
 * Copyright 2017 Saurabh Kumar 29/10/17 1:14 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.rxjava.observable.b_composition;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import pluralsight.rxjava.observable.b_composition.model.User;
import pluralsight.rxjava.observable.b_composition.model.UserSecurityStatus;
import pluralsight.rxjava.observable.b_composition.model.UserService;
import pluralsight.rxjava.observable.util.ThreadUtils;

import java.util.Comparator;

public class CompositionExample {

	public static void main(String[] args) {

		// Create and sync on an object that we will use to make sure we don't
		// hit the System.exit(0) call before our threads have had a chance
		// to complete.
		Object waitMonitor = new Object();

		synchronized (waitMonitor) {

			UserService userService = new UserService();

			// Write out a little snippet to make the json look nice...just as an example
			System.out.println("{ \"userList\" : [ ");

			// Call the user service and fetch a list of users.
			Observable.fromIterable(userService.fetchUserList())
					// Go through the events asynchronously and eliminate administrators. REPLACED parallel to publish (TODO)
					.publish(
							(userObservable) ->
									userObservable.filter(
											(user) -> user.getSecurityStatus() != UserSecurityStatus.ADMINISTRATOR)
					)

					// Sort the remaining users by security status.
					.toSortedList(Comparator.comparing(User::getSecurityStatus))

					// Make the observable run on the io scheduler since the userservice
					// might have to go over the wire (it doesn't in this example)
					.subscribeOn(Schedulers.io())   // use IO Scheduler

					.doAfterTerminate(() -> {
						// Since we have completed...we sync on the waitMonitor
						// and then call notify to wake up the "main" thread.
						synchronized (waitMonitor) {
							waitMonitor.notify();
						}

					})
					.subscribe(
							// onNext function - receives a sorted list of users
							// due to the "toSortedList" operation
							(userList) -> {
								userList.forEach((user) -> {
									System.out.println(user.toJSON());
								});
							}
					);

			// Wait until the onCompleted method wakes us up.
			ThreadUtils.wait(waitMonitor);

			// Close the json
			System.out.println("] }");
		}
		System.exit(0);
	}
}
