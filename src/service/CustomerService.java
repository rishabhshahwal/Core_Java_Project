package service;

import config.DbConfig;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public void addCustomer(Customer customer) throws SQLException
    {
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO customers(name,phone) VALUES(?,?)");
        ps.setString(1,customer.getName());
        ps.setString(2,customer.getPhone());
        ps.close();
        conn.close();
    }
    public List<Customer> getAllCustomers() throws SQLException
    {
    List<Customer> list = new ArrayList<>();
    Connection conn = DbConfig.getConnection();
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * from customers");
    while(rs.next())
    {
      list.add(new Customer(rs.getInt("id"),
              rs.getString("name"), rs.getString("phone")));
    }
     return list;
 }
 public Customer getCustomersBaseOnNum(String number) throws SQLException
 {
     Customer customer = new Customer();
     Connection conn = DbConfig.getConnection();
     Statement st = conn.createStatement();
     ResultSet rs = st.executeQuery("SELECT * from customers where phone = "+number);
     while(rs.next())
     {
         customer = new Customer(rs.getInt("id"),
                 rs.getString("name"),rs.getString("phone"));
     }
     return customer;
 }
}