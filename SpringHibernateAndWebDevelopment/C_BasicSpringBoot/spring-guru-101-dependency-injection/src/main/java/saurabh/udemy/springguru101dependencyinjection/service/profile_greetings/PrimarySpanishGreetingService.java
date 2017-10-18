package saurabh.udemy.springguru101dependencyinjection.service.profile_greetings;

import saurabh.udemy.springguru101dependencyinjection.repository.GreetingRepository;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingService;

//@Service
//@Profile("es")
//@Primary
public class PrimarySpanishGreetingService implements GreetingService {

	private final GreetingRepository greetingRepository;

	// @Autowired
	public PrimarySpanishGreetingService(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}

	@Override
	public String sayHello() {
		return greetingRepository.getSpanishGreeting();
	}
}
