package com.myshop.dao;

/**
 * Created by User on 7/6/2017.
 */
public interface CardItemDao {

    void addCardItem(CardItem cardItem);

    void removeCardItem(CardItem cardItem);

    void removeAllCardItems(Card card);

    CardItem getCardItemByProductId(int productId);
}
