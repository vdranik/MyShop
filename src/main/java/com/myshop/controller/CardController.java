package com.myshop.controller;

import com.myshop.dao.CardDao;
import com.myshop.dao.ProductDao;
import com.myshop.model.Card;
import com.myshop.model.CardItem;
import com.myshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 7/3/2017.
 */
@Controller
@RequestMapping("/rest/card")
public class CardController {

    @Autowired
    private CardDao cardDao;

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/{cardId}", method = RequestMethod.GET)
    public @ResponseBody Card read(@PathVariable(value = "cardId") String cardId){
        return cardDao.read(cardId);
    }

    @RequestMapping(value = "/{cardId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cardId") String cardId, @RequestBody Card card){
       cardDao.update(cardId, card);
    }

    @RequestMapping(value = "/{cardId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cardId") String cardId) {
        cardDao.deleteCard(cardId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") String productId, HttpServletRequest request){
        String sessionId = request.getSession(true).getId();
        Card card = cardDao.read(sessionId);

        if(card == null){
            card = cardDao.create(new Card(sessionId));
        }

        Product product = productDao.getProductById(productId);
        if(product == null){
            throw new IllegalArgumentException(new Exception());
        }

        card.addCardItem(new CardItem(product));
        cardDao.update(sessionId, card);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "productId") String productId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Card card = cardDao.read(sessionId);

        if(card == null){
            card = cardDao.create(new Card(sessionId));
        }

        Product product = productDao.getProductById(productId);
        if(product == null){
            throw new IllegalArgumentException(new Exception());
        }

        card.removeCardItem(new CardItem(product));
        cardDao.update(sessionId, card);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors(Exception e){}
}
