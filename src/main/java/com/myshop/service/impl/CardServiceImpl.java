package com.myshop.service.impl;

import com.myshop.dao.CardDao;
import com.myshop.model.Card;
import com.myshop.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDao cardDao;

    public Card getCardById(int cardId){
        return cardDao.getCardById(cardId);
    }

    public void update(Card card){
        cardDao.update(card);
    }

}
