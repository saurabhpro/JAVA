package saurabh.udemy.springguru101dependencyinjection.service;

import org.springframework.stereotype.Service;

@Service
public class PropGreetingServiceImpl implements GreetingService {
	public static final String HELLO = "Say Hello - Original";

	@Override
	public String sayHello() {
		return HELLO;
	}
}
