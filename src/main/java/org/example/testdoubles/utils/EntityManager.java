package org.example.testdoubles.utils;

import org.example.testdoubles.Customer;

public interface EntityManager {

    Customer find(Long customerID);

    void persist(Customer customer);

    void flush();

}
