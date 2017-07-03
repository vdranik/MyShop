package com.myshop.controller;

import com.myshop.dao.CardDao;
import com.myshop.dao.ProductDao;
import com.myshop.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
