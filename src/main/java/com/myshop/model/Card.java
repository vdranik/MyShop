package com.myshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by User on 7/3/2017.
 */
@Entity
public class Card implements Serializable {

    private static final long serialVersionUID = 4094888009066171884L;

    @Id
    @GeneratedValue
    private int cardId;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CardItem> cardItems;

    @OneToOne
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

    private double grandTotal;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public List<CardItem> getCardItems() {
        return cardItems;
    }

    public void setCardItems(List<CardItem> cardItems) {
        this.cardItems = cardItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}
