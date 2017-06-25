package com.myshop.dao;

import com.myshop.model.Product;

import java.util.List;

/**
 * Created by User on 6/23/2017.
 */
public interface ProductDao {

    void addProduct(Product product);

    Product getProductById(String id);

    List<Product> getAllProducts();

    void deleteProduct(String id);
}
