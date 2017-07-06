package com.myshop.service.impl;

import com.myshop.dao.CardItemDao;
import com.myshop.model.Card;
import com.myshop.model.CardItem;
import com.myshop.service.CardItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 7/6/2017.
 */
@Service
public class CardItemServiceImpl implements CardItemService {

    @Autowired
    private CardItemDao cardItemDao;

    public void addCardItem(CardItem cardItem){
        cardItemDao.addCardItem(cardItem);
    }

    public void removeCardItem(CardItem cardItem){
        cardItemDao.removeCardItem(cardItem);
    }

    public void removeAllCardItems(Card card){
        cardItemDao.removeAllCardItems(card);
    }

    public CardItem getCardItemByProductId(int productId){
        return cardItemDao.getCardItemByProductId(productId);
    }

}
