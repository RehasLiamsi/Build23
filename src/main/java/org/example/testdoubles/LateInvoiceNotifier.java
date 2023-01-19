package org.example.testdoubles;

import org.example.testdoubles.utils.EmailSender;
import org.example.testdoubles.utils.InvoiceStorage;

public class LateInvoiceNotifier {

    private final EmailSender emailSender;
    private final InvoiceStorage invoiceStorage;

    public LateInvoiceNotifier(final EmailSender emailSender, final InvoiceStorage invoiceStorage){
        this.emailSender = emailSender;
        this.invoiceStorage = invoiceStorage;
    }

    public void notifyIfLate(Customer customer)
    {
        if(invoiceStorage.hasOutstandingInvoice(customer)){
            emailSender.sendEmail(customer);
        }
    }
}