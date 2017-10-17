package saurabh.udemy.springguru101dependencyinjection.service.profile_greetings;

import org.springframework.beans.factory.annotation.Autowired;
import saurabh.udemy.springguru101dependencyinjection.repository.GreetingRepository;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingService;

//@Service
//@Profile("es")
//@Primary
public class PrimarySpanishGreetingService implements GreetingService {

	private GreetingRepository greetingRepository;

	@Autowired
	public PrimarySpanishGreetingService(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}

	@Override
	public String sayHello() {
		return greetingRepository.getSpanishGreeting();
	}
}
