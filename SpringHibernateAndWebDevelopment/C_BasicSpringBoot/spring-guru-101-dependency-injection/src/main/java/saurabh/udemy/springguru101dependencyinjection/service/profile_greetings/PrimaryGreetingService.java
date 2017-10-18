package saurabh.udemy.springguru101dependencyinjection.service.profile_greetings;

import saurabh.udemy.springguru101dependencyinjection.repository.GreetingRepository;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingService;

//@Service
//@Primary    //if there's more than 1 bean of GreetingService - use this one
//@Profile({"default", "en"})      // one profile can have only 1 @Primary
//// spring.profiles.active= //no beans means default, wrong will give error
public class PrimaryGreetingService implements GreetingService {

	private final GreetingRepository greetingRepository;

	// @Autowired auto wire should be done in @Service/@Repositior/@Component/ @Controller classes
	public PrimaryGreetingService(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}

	@Override
	public String sayHello() {
		return greetingRepository.getEnglishGreeting();
	}
}
