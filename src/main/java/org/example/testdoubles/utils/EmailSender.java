package org.example.testdoubles.utils;

import org.example.testdoubles.Customer;

public class EmailSender {
    public void sendEmail(Customer customer) {
        throw new RuntimeException("Should not be called during testing");
    }
}
