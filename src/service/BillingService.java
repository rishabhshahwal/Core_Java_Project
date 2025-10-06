package service;

import entity.Customer;
import entity.Invoice;

import java.sql.SQLException;
import java.util.List;

public class BillingService {
    public CustomerService customerService=new CustomerService();
    public InvoiceService invoiceService=new InvoiceService();

    public void createInvoice(int customerId, int vehicleId, List<Integer> serviceIds) throws SQLException
    {
        String sids="";
        for(int serviceId:serviceIds)
        {
            sids += serviceId;
        }
        invoiceService.addInvoice(new Invoice(0,customerId,vehicleId,Integer.parseInt(sids)));
        System.out.println("Invoice generated successfully...");
    }

    public void showAllInvoices() throws SQLException
    {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        for(Invoice invoice:invoices)
        {
            System.out.println(invoice);
        }
    }
}