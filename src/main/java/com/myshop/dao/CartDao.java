package com.myshop.dao;

import com.myshop.model.Cart;

/**
 * Created by User on 7/3/2017.
 */
public interface CartDao {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update (String cartId, Cart cart);

    void deleteCart(String cartId);
}
