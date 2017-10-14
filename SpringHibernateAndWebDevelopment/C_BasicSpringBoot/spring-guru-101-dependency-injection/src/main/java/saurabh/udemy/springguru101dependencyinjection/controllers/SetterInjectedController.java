package saurabh.udemy.springguru101dependencyinjection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingService;

@Controller
public class SetterInjectedController {
	private GreetingService greetingService;

	@Autowired
	void setService(@Qualifier("setterGreetingService") GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String sayHello() {
		return greetingService.sayHello();
	}

}
