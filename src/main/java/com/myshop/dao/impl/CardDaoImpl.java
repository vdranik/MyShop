package com.myshop.dao.impl;

import com.myshop.dao.CardDao;
import com.myshop.model.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Created by User on 7/3/2017.
 */

@Repository
@Transactional
public class CardDaoImpl implements CardDao {

    @Autowired
    private SessionFactory sessionFactory;

//    @Autowired
//    private CustomerOrderService customerOrderService;

    public Card getCardById(int cardId){
        Session session = sessionFactory.getCurrentSession();
        return (Card) session.get(Card.class, cardId);
    }

    public void update(Card card){
        int cardId = card.getCardId();
//        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cardId);
//        card.setGrandTotal(grandTotal);
//
//        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(card);
    }

    public Card validate(int cardId) throws IOException {
        Card card = getCardById(cardId);
        if(card == null || card.getCardItems().size() == 0){
            throw new IOException(cardId + "");
        }

        update(card);
        return card;
    }


}
