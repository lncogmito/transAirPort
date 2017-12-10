package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.dao.CategoryDAO;
import com.spring.henallux.transAirPort.model.Category;
import com.spring.henallux.transAirPort.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(value="/home")
@SessionAttributes({Constants.BASKET})
public class HomeController {
    private final MessageSource messageSource;

    @ModelAttribute(Constants.BASKET)
    public Order getCurrentOrder(){
        return new Order();
    }

    @Autowired
    public HomeController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale,@ModelAttribute(value = Constants.BASKET) Order currentBasket){
        model.addAttribute("title", messageSource.getMessage("titleHome",null,locale));
        return "integrated:home";
    }

}
