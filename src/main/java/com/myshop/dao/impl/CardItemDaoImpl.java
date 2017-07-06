package com.myshop.dao.impl;

import com.myshop.dao.CardItemDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 7/6/2017.
 */
@Repository
@Transactional
public class CardItemDaoImpl implements CardItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCardItem(CardItem cardItem){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cardItem);
        session.flush();
    }

    public void removeCardItem(CardItem cardItem){
        Session session = sessionFactory.getCurrentSession();
        session.delete(cardItem);
        session.flush();
    }

    public void removeAllCardItems(Card card){
        List<CardItem> cardItems = card.getCardItems();

        for (CardItem item : cardItems){
            removeCardItem(item);
        }
    }

    public CardItem getCardItemByProductId(int productId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CardItem where productId = ?");
        query.setInteger(0, productId);
        session.flush();

        return (CardItem) query.uniqueResult();
    }

}
