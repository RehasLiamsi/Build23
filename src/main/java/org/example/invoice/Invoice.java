package org.example.invoice;

import java.util.Objects;

public class Invoice {

    private final String customer;
    private final double value;

    public Invoice(String customer, double value) {
        this.customer = customer;
        this.value = value;
    }

    public String getCustomer() {
        return customer;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (Double.compare(invoice.value, value) != 0) return false;
        return Objects.equals(customer, invoice.customer);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = customer != null ? customer.hashCode() : 0;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
