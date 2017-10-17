package saurabh.udemy.springguru101dependencyinjection.service;

import saurabh.udemy.springguru101dependencyinjection.repository.GreetingRepository;
import saurabh.udemy.springguru101dependencyinjection.service.profile_greetings.PrimaryGermanGreetingService;
import saurabh.udemy.springguru101dependencyinjection.service.profile_greetings.PrimaryGreetingService;
import saurabh.udemy.springguru101dependencyinjection.service.profile_greetings.PrimarySpanishGreetingService;

public class GreetingServiceFactory {

	private GreetingRepository greetingRepository;

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
