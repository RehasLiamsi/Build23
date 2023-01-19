package org.example.testdoubles;

import org.example.testdoubles.utils.EntityManager;

public class CustomerReader {

    private EntityManager entityManager;

    public String findFullName(Long customerID) {
        Customer customer = entityManager.find(customerID);
        return customer.getFirstName() + " " + customer.getLastName();
    }
}
