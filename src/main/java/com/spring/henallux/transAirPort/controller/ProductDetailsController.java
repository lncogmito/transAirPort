package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.entity.OrderEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Locale;

@Controller
@RequestMapping(value="/productDetails")
@SessionAttributes({Constants.BASKET})
public class ProductDetailsController {
    private final MessageSource messageSource;

    @Autowired
    public ProductDetailsController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale){
        model.addAttribute(Constants.BASKET,new OrderEntity());
        model.addAttribute("title", messageSource.getMessage("titleProductDetails",null,locale));
        return "integrated:productDetails";
    }
}
