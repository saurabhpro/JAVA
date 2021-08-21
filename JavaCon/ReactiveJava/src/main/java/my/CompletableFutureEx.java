/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package my;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class CompletableFutureEx {
	public static void main(String[] args) {
		CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
				() -> {
					try {
						// Simulate long running task
						Thread.sleep(5000, 50);
					} catch (InterruptedException ignored) {
					}
					return 10;
				});

		new CompletableFutureEx().countEvents();

		Stream.iterate(1L, n -> n * 5)
				.skip(2) //skips first 2 numbers
				.limit(10)
				.forEach(System.out::println);
	}

	public CompletableFuture countEvents() {
		CompletableFuture<Integer> result = new CompletableFuture<>();
		AtomicInteger count = new AtomicInteger();
		Observable.just("1", "2", "3", "err", "4")
				.subscribe(ev -> {
							try {
								int x = Integer.parseInt(ev);
								count.set(count.get() + x);
							} catch (NumberFormatException ignored) {
							}
						},
						throwable -> result.complete(0),
						() -> {
							try {
								//simulate io delay
								Thread.sleep(3000);
							} catch (InterruptedException ignored) {
							}
							result.complete(count.get());
						}
				);
		return result;
	}
}
