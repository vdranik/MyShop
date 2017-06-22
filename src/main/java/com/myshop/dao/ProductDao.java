package com.myshop.dao;

import com.myshop.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 6/22/2017.
 */
public class ProductDao {

    private List<Product> productList;

    public List<Product> getProductList(){
        Product product_example_1 = new Product();
        product_example_1.setProductId("1");
        product_example_1.setProductName("XBOX ONE");
        product_example_1.setProductCategory("Console");
        product_example_1.setProductDescription("Perfect gamestation");
        product_example_1.setProductPrice(500);
        product_example_1.setProductCondition("NEW");
        product_example_1.setProductStatus("ACTIVE");
        product_example_1.setUnitInStock(11);
        product_example_1.setProductManufacturer("Microsoft");

        Product product_example_2 = new Product();
        product_example_2.setProductId("2");
        product_example_2.setProductName("Far Cry 5");
        product_example_2.setProductCategory("Game");
        product_example_2.setProductDescription("SupaPupa Game");
        product_example_2.setProductPrice(40);
        product_example_2.setProductCondition("NEW");
        product_example_2.setProductStatus("ACTIVE");
        product_example_2.setUnitInStock(111);
        product_example_2.setProductManufacturer("Ubisoft");

        Product product_example_3 = new Product();
        product_example_3.setProductId("3");
        product_example_3.setProductName("Far Cry 5 poster");
        product_example_3.setProductCategory("Accessory");
        product_example_3.setProductDescription("SupaPupa Poster");
        product_example_3.setProductPrice(4);
        product_example_3.setProductCondition("NEW");
        product_example_3.setProductStatus("ACTIVE");
        product_example_3.setUnitInStock(1111);
        product_example_3.setProductManufacturer("ChinaPrintLTD");

        productList = new ArrayList<Product>();
        productList.add(product_example_1);
        productList.add(product_example_2);
        productList.add(product_example_3);
        return productList;
    }

    public Product getProductById(String productId) throws IOException {
         for(Product product: getProductList()){
             if(product.getProductId().equals(productId)){
                 return product;
             }
         }

         throw new IOException("No product found");
    }
}
