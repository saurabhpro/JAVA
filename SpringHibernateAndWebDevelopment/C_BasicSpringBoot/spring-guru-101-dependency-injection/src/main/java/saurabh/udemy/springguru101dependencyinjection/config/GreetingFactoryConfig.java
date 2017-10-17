package saurabh.udemy.springguru101dependencyinjection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import saurabh.udemy.springguru101dependencyinjection.repository.GreetingRepository;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingService;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingServiceFactory;

@Configuration
public class GreetingFactoryConfig {

	@Bean
	GreetingServiceFactory getGreetingServiceFactory(GreetingRepository greetingRepository) {
		return new GreetingServiceFactory(greetingRepository);
	}

	@Bean
	@Primary    //if there's more than 1 bean of GreetingService - use this one
	@Profile({"default", "en"})
		// one profile can have only 1 @Primary
		// spring.profiles.active= //no beans means default, wrong will give error
	GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("en");
	}

	@Bean
	@Primary
	@Profile("de")
	GreetingService primaryGermanGreetingService(GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("en");
	}

	@Bean
	@Profile("es")
	@Primary
	GreetingService primarySpanishGreetingService(GreetingServiceFactory greetingServiceFactory) {
		return greetingServiceFactory.createGreetingService("es");
	}
}
