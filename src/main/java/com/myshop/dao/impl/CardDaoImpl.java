package com.myshop.dao.impl;

import com.myshop.dao.CardDao;
import com.myshop.model.Card;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 7/3/2017.
 */

public class CardDaoImpl{

//    private Map<String, Card> listOfCards;
//
//    public CardDaoImpl() {
//        listOfCards = new HashMap<String, Card>();
//    }
//
//    public Card create(Card card) {
//        if(listOfCards.keySet().contains(card.getCardId())){
//            throw new IllegalArgumentException(String.format("Can not create a card. The card with the given id(%) already " +
//            "exists", card.getCardId()));
//        }
//
//        //listOfCards.put(card.getCardId(), card);
//        return card;
//    }
//
//    public Card read(String cardId) {
//        return listOfCards.get(cardId);
//    }
//
//    public void update(String cardId, Card card) {
//        if(!listOfCards.keySet().contains(cardId)){
//            throw new IllegalArgumentException(String.format("Can not update a card. The card with the given id(%) " +
//                    "doesn't exists", card.getCardId()));
//        }
//
//        listOfCards.put(cardId, card);
//    }
//
//    public void deleteCard(String cardId) {
//        if(!listOfCards.keySet().contains(cardId)){
//            throw new IllegalArgumentException(String.format("Can not delete a card. The card with the given id(%) " +
//                    "doesn't exists", cardId));
//        }
//
//        listOfCards.remove(cardId);
//    }
}
