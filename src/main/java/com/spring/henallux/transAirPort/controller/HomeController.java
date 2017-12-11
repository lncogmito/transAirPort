package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.model.Order;
import com.spring.henallux.transAirPort.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

@Controller
@RequestMapping(value="/home")
@SessionAttributes({ToolKit.BASKET})
public class HomeController {
    private final MessageSource messageSource;

    @ModelAttribute(ToolKit.BASKET)
    public LinkedHashMap<Integer,OrderLine> getCurrentOrder(){
        return new LinkedHashMap<>();
    }

    @Autowired
    public HomeController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale){
        model.addAttribute("title", messageSource.getMessage("titleHome",null,locale));
        return "integrated:home";
    }

}
