package com.spring.henallux.transAirPort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping ("/logged")
public class LoggedController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale){
        return "redirect:/home";
    }

}
