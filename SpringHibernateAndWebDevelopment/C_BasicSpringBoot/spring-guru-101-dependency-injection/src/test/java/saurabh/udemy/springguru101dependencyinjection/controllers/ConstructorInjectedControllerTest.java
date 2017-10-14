package saurabh.udemy.springguru101dependencyinjection.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;
import saurabh.udemy.springguru101dependencyinjection.service.GreetingServiceImpl;


class ConstructorInjectedControllerTest {
	private ConstructorInjectedController constructorInjectedController;

	@BeforeEach
	void setUp() {
		this.constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
	}

	@Test
	@Description("Test It")
		//Does Nothing
	void sayHello() {
		Assertions.assertEquals(GreetingServiceImpl.HELLO, this.constructorInjectedController.sayHello());
	}

}