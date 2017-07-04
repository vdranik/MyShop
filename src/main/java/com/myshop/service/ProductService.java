package com.myshop.service;

import com.myshop.model.Product;

import java.util.List;

/**
 * Created by User on 7/4/2017.
 */
public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int productId);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
