package org.example.invoice;

import java.util.List;
import java.util.stream.Collectors;

public class InvoiceFilter {

    private final InvoiceDao invoiceDao;

    public InvoiceFilter(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }

    public List<Invoice> filter() {
        //Must be modified to use dependency inversion
        //InvoiceDao invoiceDao = new InvoiceDao();
        List<Invoice> allInvoices = invoiceDao.all();

        return allInvoices.stream()
                .filter(invoice -> invoice.getValue() < 100.0)
                .collect(Collectors.toList());
    }

    public List<Invoice> filterInvoicesGreaterThan100() {
        List<Invoice> allInvoices = invoiceDao.all();

        return allInvoices.stream()
                .filter(invoice -> invoice.getValue() > 100.0)
                .collect(Collectors.toList());
    }
}