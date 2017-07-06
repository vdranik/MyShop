package com.myshop.controller;

import com.myshop.model.Card;
import com.myshop.model.Customer;
import com.myshop.model.CustomerOrder;
import com.myshop.service.CardService;
import com.myshop.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @Autowired
    private CardService cardService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cardId}")
    public String createOrder(@PathVariable("cardId") int cardId){
        CustomerOrder customerOrder = new CustomerOrder();
        Card card = cardService.getCardById(cardId);
        customerOrder.setCard(card);

        Customer customer = card.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customer.setShippingAddress(customer.getShippingAddress());

        customerOrderService.addCustomerOrder(customerOrder);

        return "redirect:/checkout?cardId=" + cardId;

    }
}
