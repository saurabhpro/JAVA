package saurabh.udemy.springguru101dependencyinjection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingService;

@Controller
public class PropertyInjectedController {

	@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
	@Autowired
	@Qualifier("propGreetingServiceImpl")
	GreetingService greetingServiceImpl;    // if this name matches injected obj name - spring auto resolves it GIVEN there is no @Primary
	// hence use @Qualifier("")

	public String sayHello() {
		return greetingServiceImpl.sayHello();
	}
}
