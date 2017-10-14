package saurabh.udemy.springguru101dependencyinjection.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingServiceImpl;

class SetterInjectedControllerTest {
	private SetterInjectedController setterInjectedController;

	@BeforeEach
	void setUp() {
		this.setterInjectedController = new SetterInjectedController();

		// class can be created without seting up greeting
		this.setterInjectedController.setService(new GreetingServiceImpl());
	}

	@Test
	@Description("Test It")
		//Does Nothing
	void sayHello() {
		Assertions.assertEquals(GreetingServiceImpl.HELLO, this.setterInjectedController.sayHello());
	}

}