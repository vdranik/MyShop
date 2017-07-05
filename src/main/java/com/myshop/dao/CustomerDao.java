package com.myshop.dao;

/**
 * Created by User on 7/6/2017.
 */
import com.myshop.model.Customer;

import java.util.List;

public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
}
