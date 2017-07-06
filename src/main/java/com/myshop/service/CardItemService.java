package com.myshop.service;

import com.myshop.model.Card;
import com.myshop.model.CardItem;

/**
 * Created by User on 7/6/2017.
 */
public interface CardItemService {

    void addCardItem(CardItem cardItem);

    void removeCardItem(CardItem cardItem);

    void removeAllCardItems(Card cart);

    CardItem getCardItemByProductId(int productId);

}