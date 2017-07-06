package com.myshop.controller;

import com.myshop.model.Card;
import com.myshop.model.CardItem;
import com.myshop.model.Customer;
import com.myshop.model.Product;
import com.myshop.service.CardItemService;
import com.myshop.service.CardService;
import com.myshop.service.CustomerService;
import com.myshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User on 7/6/2017.
 */
@Controller
@RequestMapping("/rest/card")
public class CardResources {

    @Autowired
    private CardService cardService;

    @Autowired
    private CardItemService cardItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/{cardId}")
    public @ResponseBody Card getCardById(@PathVariable(value = "cardId") int cardId){
        return cardService.getCardById(cardId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        Card card = customer.getCard();
        Product product = productService.getProductById(productId);
        List<CardItem> cardItems = card.getCardItems();

        for (int i=0; i < cardItems.size(); i++){
            if(product.getProductId() == cardItems.get(i).getProduct().getProductId()){
                CardItem cardItem = cardItems.get(i);
                cardItem.setQuantity(cardItem.getQuantity() + 1);
                cardItem.setTotalPrice(product.getProductPrice()*cardItem.getQuantity());
                cardItemService.addCardItem(cardItem);

                return;
            }
        }

        CardItem cardItem = new CardItem();
        cardItem.setProduct(product);
        cardItem.setQuantity(1);
        cardItem.setTotalPrice(product.getProductPrice()*cardItem.getQuantity());
        cardItem.setCard(card);
        cardItemService.addCardItem(cardItem);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "productId") int productId){
        CardItem cardItem = cardItemService.getCardItemByProductId(productId);
        cardItemService.removeCardItem(cardItem);

    }

    @RequestMapping(value = "/{cardId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCard(@PathVariable(value = "cardId") int cardId){
        Card card = cardService.getCardById(cardId);
        cardItemService.removeAllCardItems(card);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors (Exception ex){

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors (Exception ex){

    }
}
