package com.myshop.controller;

import com.myshop.dao.ProductDao;
import com.myshop.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created by User on 6/21/2017.
 */
@Controller
public class HomeController {

    private ProductDao productDao = new ProductDao();

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products = productDao.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String getProduct(@PathVariable String productId, Model model) throws IOException {
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);

        return "viewProduct";
    }
}
