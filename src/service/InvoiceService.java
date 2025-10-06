package service;

import config.DbConfig;
import entity.Customer;
import entity.Invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceService {

    public void addInvoice(Invoice invoice) throws SQLException
    {
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps =
                conn.prepareStatement("INSERT INTO invoices (customer_id,vehicle_id,service_id) VALUES (?,?,?)");
        ps.setInt(1,invoice.getCustomerId());
        ps.setInt(2,invoice.getVehicleId());
        ps.setInt(3,invoice.getServiceId());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public List<Invoice> getAllInvoices() throws SQLException
    {
        List<Invoice> list = new ArrayList<>();
        Connection conn = DbConfig.getConnection();
        Statement st= conn.createStatement();
        ResultSet rs= st.executeQuery("SELECT * from invoices");
        while(rs.next())
        {
            list.add(new Invoice(rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getInt("vehicle_id"),rs.getInt("service_id")));
        }
        return list;
    }
}