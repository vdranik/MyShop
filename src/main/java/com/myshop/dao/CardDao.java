package com.myshop.dao;

import java.io.IOException;

/**
 * Created by User on 7/3/2017.
 */
public interface CardDao {

    Card getCardById(int cardId);

    Card validate(int cardId) throws IOException;

    void update(Card card);

}
