package com.myshop.service.impl;

import com.myshop.dao.CustomerOrderDao;
import com.myshop.service.CardService;
import com.myshop.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustmerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CardService cardService;

    public void addCustomerOrder(CustomerOrder customerOrder){
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cardId){
        double grandTotal = 0;
        Card card = cardService.getCardById(cardId);
        List<CardItem> cardItems = card.getCardItems();

        for (CardItem item : cardItems){
            grandTotal += item.getTotalPrice();
        }

        return grandTotal;
    }

}
