package saurabh.udemy.springguru101dependencyinjection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import saurabh.udemy.springguru101dependencyinjection.repository.GreetingRepository;

@Service
@Primary    //if there's more than 1 bean of GreetingService - use this one
@Profile({"default", "en"})      // one profile can have only 1 @Primary
// spring.profiles.active= //no beans means default, wrong will give error
public class PrimaryGreetingService implements GreetingService {

	private GreetingRepository greetingRepository;

	@Autowired
	public PrimaryGreetingService(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}

	@Override
	public String sayHello() {
		return greetingRepository.getEnglishGreeting();
	}
}
