package org.example.testdoubles.utils;

import org.example.testdoubles.Customer;

public class InvoiceStorage {
    public boolean hasOutstandingInvoice(Customer customer) {
        throw new RuntimeException("Should not be called during testing");
    }
}
