package saurabh.udemy.springguru101dependencyinjection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingService;

@Controller
public class ConstructorInjectedController {
	private final GreetingService greetingService;

	@Autowired
		// Optional - But do use it
	ConstructorInjectedController(@Qualifier("constructorGreetingServiceImpl") GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String sayHello() {
		return greetingService.sayHello();
	}
}
