package saurabh.udemy.springguru101dependencyinjection.service;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGreetingService implements GreetingService {
	@Override
	public String sayHello() {
		return "I am saying Hello from Constructor Injection";
	}
}
