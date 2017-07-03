package com.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 7/3/2017.
 */
@Controller
@RequestMapping("/card")
public class CardItemController {

    @RequestMapping
    public String doGet(HttpServletRequest request){
        return "redirect:/card/" + request.getSession(true).getId();
    }

    @RequestMapping(value = "/{cardId}", method = RequestMethod.GET)
    public String getCard(@PathVariable (value = "cardId") String cardId, Model model){
        model.addAttribute("cardId", cardId);

        return "card";
    }
}
