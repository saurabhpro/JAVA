package saurabh.udemy.springguru101dependencyinjection.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;
import saurabh.udemy.springguru101dependencyinjection.service.PropGreetingServiceImpl;

class PropertyInjectedControllerTest {
	private PropertyInjectedController propertyInjectedController;

	@BeforeEach
	void setUp() {
		this.propertyInjectedController = new PropertyInjectedController();

		// class can be created without seting up greeting
		this.propertyInjectedController.greetingServiceImpl = new PropGreetingServiceImpl();
	}

	@Test
	@Description("Test It") //Does Nothing
	@DisplayName("Testing Property Injection")
	void sayHello() {
		Assertions.assertEquals(PropGreetingServiceImpl.HELLO, this.propertyInjectedController.sayHello());
	}

}