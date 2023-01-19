package org.example.testdoubles;

import org.example.testdoubles.utils.EntityManager;
import org.example.testdoubles.utils.Logger;

public class CustomerDao {

    private EntityManager entityManager;

    private Logger logger;

    public void saveCustomer(String firstName, String lastName) {
        if(firstName == null || lastName==null)
        {
            logger.error("Missing customer information");
            throw new IllegalArgumentException();
        }
        Customer customer = new Customer(firstName,lastName);
        entityManager.persist(customer);
        entityManager.flush();
        logger.info("Saved customer with id {}", customer.getId());
    }

}