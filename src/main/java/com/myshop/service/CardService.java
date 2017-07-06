package com.myshop.service;

import com.myshop.model.Card;

public interface CardService {

    Card getCardById(int cartId);

    void update(Card cart);
}
