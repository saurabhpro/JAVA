package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class TicketTaker {
	private final AtomicInteger ticketsTaken;
	private long ticketsSold;

	public TicketTaker() {
		ticketsSold = 0;
		ticketsTaken = new AtomicInteger(0);
	}

	public static void main(String[] matinee) {
		new TicketTaker().performJob();
	}

	public void performJob() {
		IntStream.iterate(1, p -> p + 1)
				.parallel()
				.limit(10)
				.forEach(i -> ticketsTaken.getAndIncrement());


		IntStream.iterate(1, q -> q + 1)
				.limit(5)
				.parallel()
				.forEach(i -> ++ticketsSold);
		System.out.print(ticketsTaken + " " + ticketsSold);
	}
}