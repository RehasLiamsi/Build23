package org.example.testdoubles.utils;

public class Logger {
    public void error(String missingCustomerInformation) {
        throw new RuntimeException("Should not be called during testing");
    }

    public void info(String s, long id) {
        throw new RuntimeException("Should not be called during testing");
    }
}
