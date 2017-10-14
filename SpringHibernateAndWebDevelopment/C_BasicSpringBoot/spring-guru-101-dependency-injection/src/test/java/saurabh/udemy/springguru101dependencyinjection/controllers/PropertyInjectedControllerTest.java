package saurabh.udemy.springguru101dependencyinjection.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingServiceImpl;

class PropertyInjectedControllerTest {
	private PropertyInjectedController propertyInjectedController;

	@BeforeEach
	void setUp() {
		this.propertyInjectedController = new PropertyInjectedController();

		// class can be created without seting up greeting
		this.propertyInjectedController.greetingServiceImpl = new GreetingServiceImpl();
	}

	@Test
	@Description("Test It") //Does Nothing
	@DisplayName("Testing Property Injection")
	void sayHello() {
		Assertions.assertEquals(GreetingServiceImpl.HELLO, this.propertyInjectedController.sayHello());
	}

}