package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "integrated:admin";
    }
}
