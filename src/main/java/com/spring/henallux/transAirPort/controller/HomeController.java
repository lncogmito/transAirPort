package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/home")
@SessionAttributes({Constants.CURRENT_USER})
public class HomeController {

    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        //model.addAttribute(Constants.CURRENT_USER, new User());
        return "integrated:home";
    }

    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public String getLoggingInForm(Model model, @Valid @ModelAttribute(value=Constants.CURRENT_USER)User userLogging, final BindingResult errors){
        if(errors.hasErrors()){
            System.out.println(userLogging.getUsername());
            return "integrated:home";
        }else{
            System.out.println(userLogging.getUsername());
            return "redirect:/success";
        }
    }

}
