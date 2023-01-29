package org.example.testable;

public class LoggerImpl implements Logger {
    boolean logIsCalled = false;
    int count = 0;

    @Override
    public void log(LogLevel logLevel, String logText) {
        logIsCalled = true;
        count++;
    }
}
