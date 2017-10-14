package saurabh.udemy.springguru101dependencyinjection.service;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService {
	@Override
	public String sayHello() {
		return "from Setter Hello";
	}
}
