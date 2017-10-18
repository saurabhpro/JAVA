package saurabh.udemy.springguru101dependencyinjection.service.profile_greetings;

import saurabh.udemy.springguru101dependencyinjection.repository.GreetingRepository;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingService;

//@Service
//@Primary
//@Profile("de")
public class PrimaryGermanGreetingService implements GreetingService {
	private final GreetingRepository greetingRepository;

	//@Autowired
	public PrimaryGermanGreetingService(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}

	@Override
	public String sayHello() {
		return greetingRepository.getGermanGreeting();
	}
}
