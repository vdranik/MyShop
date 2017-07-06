package com.myshop.dao;

import com.myshop.model.Card;

import java.io.IOException;

public interface CardDao {

    Card getCardById(int cardId);

    Card validate(int cardId) throws IOException;

    void update(Card card);

}

