package com.myshop.dao.impl;

import com.myshop.dao.CartDao;
import com.myshop.model.Cart;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 7/3/2017.
 */
public class CartDaoImpl implements CartDao{

    private Map<String, Cart> listOfCarts;

    public CartDaoImpl() {
        listOfCarts = new HashMap<String, Cart>();
    }

    public Cart create(Cart cart) {
        if(listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Can not create a cart. The cart with the given id(%) already " +
            "exists", cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    public void update(String cartId, Cart cart) {
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Can not update a cart. The cart with the given id(%) " +
                    "doesn't exists", cart.getCartId()));
        }

        listOfCarts.put(cartId, cart);
    }

    public void deleteCart(String cartId) {
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Can not delete a cart. The cart with the given id(%) " +
                    "doesn't exists", cartId));
        }

        listOfCarts.remove(cartId);
    }
}
