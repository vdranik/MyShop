package com.myshop.dao;

import com.myshop.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 6/22/2017.
 */
public class ProductDao {

    private List<Product> productList;

    public List<Product> getProductList(){
        Product product_example = new Product();

        product_example.setProductName("XBOX ONE");
        product_example.setProductCategory("Game Station");
        product_example.setProductDescription("Perfect gamestation");
        product_example.setProductPrice(500);
        product_example.setProductCondition("NEW");
        product_example.setProductStatus("ACTIVE");
        product_example.setUnitInStock(11);
        product_example.setProductManufacturer("Microsoft");

        productList = new ArrayList<Product>();
        productList.add(product_example);
        return productList;
    }


}
