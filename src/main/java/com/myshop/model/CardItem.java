package com.myshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CardItem implements Serializable {

    private static final long serialVersionUID = -904360230041854157L;

    @Id
    @GeneratedValue
    private int cardItemId;

    @ManyToOne
    @JoinColumn(name = "cardId")
    @JsonIgnore
    private Card card;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;
    private double totalPrice;


    public int getCardItemId() {
        return cardItemId;
    }

    public void setCardItemId(int cardItemId) {
        this.cardItemId = cardItemId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
