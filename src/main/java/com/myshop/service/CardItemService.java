package com.myshop.service;


import com.myshop.model.Card;
import com.myshop.model.CardItem;

public interface CardItemService {

    void addCardItem(CardItem cardItem);

    void removeCardItem(CardItem cardItem);

    void removeAllCardItems(Card card);

    CardItem getCardItemByProductId(int productId);

}
