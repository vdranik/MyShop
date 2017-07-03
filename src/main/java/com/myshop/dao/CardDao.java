package com.myshop.dao;

import com.myshop.model.Card;

/**
 * Created by User on 7/3/2017.
 */
public interface CardDao {

    Card create(Card card);

    Card read(String cardId);

    void update (String cardId, Card card);

    void deleteCard(String cardId);
}
