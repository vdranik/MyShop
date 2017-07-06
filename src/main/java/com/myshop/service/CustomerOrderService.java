package com.myshop.service;

import com.myshop.model.CustomerOrder;

/**
 * Created by User on 7/6/2017.
 */
public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
}
