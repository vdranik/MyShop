package com.myshop.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 7/3/2017.
 */
public class Card {

    private String cardId;
    private Map<String, CardItem> cardItems;
    private double grandTotal;

    private Card(){
        cardItems = new HashMap<String, CardItem>();
        grandTotal = 0;
    }

    public Card(String cardId) {
        this();
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Map<String, CardItem> getCardItems() {
        return cardItems;
    }

    public void setCardItems(Map<String, CardItem> cardItems) {
        this.cardItems = cardItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void addCardItem(CardItem cardItem){
        String productId = cardItem.getProduct().getProductId();

        if(cardItems.containsKey(productId)){
            CardItem existingCardItem = cardItems.get(productId);
            existingCardItem.setQuantity(existingCardItem.getQuantity() + cardItem.getQuantity());
            cardItems.put(productId, existingCardItem);
        } else {
            cardItems.put(productId, cardItem);
        }

        updateGrandTotal();
    }

    public void removeCardItem(CardItem cardItem){
        String productId = cardItem.getProduct().getProductId();

        cardItems.remove(productId);
        updateGrandTotal();
    }

    private void updateGrandTotal() {
        grandTotal = 0;

        for(CardItem cardItem : cardItems.values() ){
            grandTotal = grandTotal + cardItem.getTotalPrice();
        }
    }
}
