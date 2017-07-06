package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by User on 7/6/2017.
 */
@Controller
@RequestMapping("/customer/card")
public class CardController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String getCard(@AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        int cardId = customer.getCard().getCardId();

        return "redirect:/customer/card/" + cardId;
    }


    @RequestMapping("/{cardId}")
    public String getCardRedirect(@PathVariable(value = "cardId") int cardId, Model model){
        model.addAttribute("cardId", cardId);

        return "card";
    }

}