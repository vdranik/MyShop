package com.myshop.service;

import com.myshop.model.Card;

/**
 * Created by User on 7/6/2017.
 */
public interface CardService {

    Card getCardById(int cartId);

    void update(Card cart);
}
