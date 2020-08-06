package com.saurabh.junit5basics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;

class TestReporterDemo {

    /*
    In JUnit Jupiter you should use TestReporter where you used to print information to stdout or stderr in JUnit 4.
    Using @RunWith(JUnitPlatform.class) will even output all reported entries to stdout.
     */
    @Test
    void reportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("a key", "a value");
    }

    @Test
    void reportSeveralValues(TestReporter testReporter) {
        HashMap<String, String> values = new HashMap<>();
        values.put("user name", "dk38");
        values.put("award year", "1974");

        testReporter.publishEntry(values);
    }

}