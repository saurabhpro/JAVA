/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.saurabh.future;

import io.reactivex.Observable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class CompletableFutureEx {
	public static void main(String[] args) {
		CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
				() -> {
					try {
						// Simulate long running task
						Thread.sleep(5000);
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
		CompletableFuture result = new CompletableFuture<>();
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
