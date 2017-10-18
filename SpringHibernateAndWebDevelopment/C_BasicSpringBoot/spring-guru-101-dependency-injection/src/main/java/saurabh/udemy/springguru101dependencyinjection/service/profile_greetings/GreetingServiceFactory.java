package saurabh.udemy.springguru101dependencyinjection.service.profile_greetings;

import saurabh.udemy.springguru101dependencyinjection.repository.GreetingRepository;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingService;

public class GreetingServiceFactory {

	private final GreetingRepository greetingRepository;

	public GreetingServiceFactory(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}

	public GreetingService createGreetingService(String language) {
		switch (language) {
			case "en":
				return new PrimaryGreetingService(greetingRepository);
			case "de":
				return new PrimaryGermanGreetingService(greetingRepository);
			case "es":
				return new PrimarySpanishGreetingService(greetingRepository);
			default:
				return new PrimaryGreetingService(greetingRepository);
		}

	}
}
