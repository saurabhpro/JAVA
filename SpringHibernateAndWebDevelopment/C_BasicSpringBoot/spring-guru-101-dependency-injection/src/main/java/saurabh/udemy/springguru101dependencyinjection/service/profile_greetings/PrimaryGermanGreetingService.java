package saurabh.udemy.springguru101dependencyinjection.service.profile_greetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import saurabh.udemy.springguru101dependencyinjection.repository.GreetingRepository;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingService;

@Service
@Primary
@Profile("de")
public class PrimaryGermanGreetingService implements GreetingService {
	private GreetingRepository greetingRepository;

	@Autowired
	public PrimaryGermanGreetingService(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}

	@Override
	public String sayHello() {
		return greetingRepository.getGermanGreeting();
	}
}
