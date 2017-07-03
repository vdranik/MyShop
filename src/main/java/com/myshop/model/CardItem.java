package com.myshop.model;

/**
 * Created by User on 7/3/2017.
 */
public class CardItem {

    private Product product;
    private int quantity;
    private double totalPrice;

    public CardItem(){
    }

    public CardItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.totalPrice = getProduct().getProductPrice();
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
