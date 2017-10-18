package com.saurabh.junit5dynamictests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitPlatform.class)
class TranslatorEngineJunit4StaticTest {

	private TranslatorEngine translatorEngine;

	@BeforeEach
	void setUp() {
		translatorEngine = new TranslatorEngine();
	}

	@Test
	void testTranslateHello() {
		assertEquals("Bonjour", translatorEngine.translate("Hello"));
	}

	@Test
	void testTranslateYes() {
		assertEquals("Oui", translatorEngine.translate("Yes"));
	}

	@Test
	void testTranslateNo() {
		assertEquals("Non", translatorEngine.translate("No"));
	}
}