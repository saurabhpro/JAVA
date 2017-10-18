package saurabh.udemy.springguru101dependencyinjection.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;
import saurabh.udemy.springguru101dependencyinjection.service.PropGreetingServiceImpl;

class SetterInjectedControllerTest {
	private SetterInjectedController setterInjectedController;

	@BeforeEach
	void setUp() {
		this.setterInjectedController = new SetterInjectedController();

		// class can be created without seting up greeting
		this.setterInjectedController.setService(new PropGreetingServiceImpl());
	}

	@Test
	@Description("Test It")
		//Does Nothing
	void sayHello() {
		Assertions.assertEquals(PropGreetingServiceImpl.HELLO, this.setterInjectedController.sayHello());
	}

}