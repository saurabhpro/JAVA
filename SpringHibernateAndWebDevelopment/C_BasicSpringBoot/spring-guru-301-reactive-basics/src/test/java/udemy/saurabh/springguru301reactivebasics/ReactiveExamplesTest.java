package udemy.saurabh.springguru301reactivebasics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import udemy.saurabh.springguru301reactivebasics.model.Person;
import udemy.saurabh.springguru301reactivebasics.model.PersonCommand;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

/**
 * Created by jt on 8/24/17.
 */
class ReactiveExamplesTest {

	private final Logger log = LoggerFactory.getLogger(ReactiveExamplesTest.class);

	//charecters from Burn Notice
	private final Person michael = new Person("Michael", "Weston");
	private final Person fiona = new Person("Fiona", "Glenanne");
	private final Person sam = new Person("Sam", "Axe");
	private final Person jesse = new Person("Jesse", "Porter");

	@Test
	@DisplayName("Test Mono with block simple")
	void monoTests() throws Exception {
		//create new person mono
		// just is going to create a Mono item to onNext
		Mono<Person> personMono = Mono.just(michael);

		//get person object from mono publisher
		// block() Subscribe to this Mono and block indefinitely until a next signal is received.
		// Returns that value, or null if the Mono completes empty.
		// In case the Mono errors, the original exception is thrown (wrapped in a RuntimeException if it was a checked exception).
		Person person = personMono.block(); // each block() will trigger a new subscription:

		// output name
		log.info(person.sayMyName());
	}

	@Test
	@DisplayName("Test Mono mapping")
	void monoTransform() throws Exception {
		//create new person mono
		Mono<Person> personMono = Mono.just(fiona);

		// Transform the item emitted by this Mono by applying a synchronous function to it.
		PersonCommand command = personMono
				.map(person -> { //type transformation
					return new PersonCommand(person);
				})
				.block();

		log.info(command.sayMyName());
	}

	@Test
	@DisplayName("Test Mono Filtering with exception since no result")
	void monoFilter() throws Exception {
		Mono<Person> personMono = Mono.just(sam);

		//filter example
		Person samAxe = personMono
				.filter(person -> person.getFirstName().equalsIgnoreCase("foo"))
				.block();

		// samAxe is null - but we can also subscribe to it instead of block
		Assertions.assertThrows(NullPointerException.class, () -> log.info(samAxe.sayMyName()) /*throws NPE*/);
	}

	@Test
	@DisplayName("Test Mono Filtering with one result")
	void monoFilter2() throws Exception {
		Mono<Person> personMono = Mono.just(sam);

		//filter example
		personMono
				.filter(person -> person.getFirstName().equalsIgnoreCase("sam"))
				.subscribe(person -> System.out.println(person.getFirstName()));        // subscribe on empty result just skips
	}

	@Test
	@DisplayName("Test Flux subscribe")
	void fluxTest() throws Exception {

		// A Reactive Streams Publisher that emits 0 to N elements, and then completes(successfully or with an error).
		Flux<Person> people = Flux.just(michael, fiona, sam, jesse);

		people.subscribe(person -> log.info(person.sayMyName()));

	}

	@Test
	@DisplayName("Test Flux filters & subscribe")
	void fluxTestFilter() throws Exception {

		Flux<Person> people = Flux.just(michael, fiona, sam, jesse);

		people.filter(person -> person.getFirstName().equals(fiona.getFirstName()))
				.subscribe(person -> log.info(person.sayMyName()));

	}

	@Test
	@DisplayName("Test Flux dealyElement with no output")
	void fluxTestDelayNoOutput() throws Exception {

		Flux<Person> people = Flux.just(michael, fiona, sam, jesse);

		// delay EACH element to come after 1 second
		// however till then our method terminates so no output
		people.delayElements(Duration.ofSeconds(1))
				.subscribe(person -> log.info(person.sayMyName()));

	}

	@Test
	@DisplayName("Test Flux output till all countdown reaches 0")
	void fluxTestDelay() throws Exception {

		CountDownLatch countDownLatch = new CountDownLatch(1);

		Flux<Person> people = Flux.just(michael, fiona, sam, jesse);

		// delay EACH element to come after 1 second
		// however till then our method terminates so no output
		people.delayElements(Duration.ofSeconds(1))
				.doOnComplete(() -> countDownLatch.countDown())                // when Flux succeeds add this behavior
				.subscribe(person -> log.info(person.sayMyName()));

		// Causes the current thread to wait until the latch has counted down to
		// zero, unless the thread is interrupted.
		countDownLatch.await();
	}

	@Test
	@DisplayName("Test Flux output filtered till all countdown reaches 0")
	void fluxTestFilterDelay() throws Exception {

		CountDownLatch countDownLatch = new CountDownLatch(1);

		Flux<Person> people = Flux.just(michael, fiona, sam, jesse);

		// delay EACH element to come after 1 second
		// however till then our method terminates so no output
		people.delayElements(Duration.ofSeconds(1))
				.filter(person -> person.getFirstName().contains("i"))
				.doOnComplete(countDownLatch::countDown)
				.subscribe(person -> log.info(person.sayMyName()));

		// Causes the current thread to wait until the latch has counted down to
		// zero, unless the thread is interrupted.
		countDownLatch.await();
	}

}
