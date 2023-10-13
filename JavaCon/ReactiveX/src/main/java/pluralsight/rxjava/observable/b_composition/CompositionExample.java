/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.rxjava.observable.b_composition;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
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
