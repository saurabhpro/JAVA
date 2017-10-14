package saurabh.udemy.springguru101dependencyinjection.controllers;

import org.springframework.stereotype.Controller;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingService;

@Controller
public class MyController {

	private GreetingService greetingService;

	public MyController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String sayHello() {
		return greetingService.sayHello();
	}
}