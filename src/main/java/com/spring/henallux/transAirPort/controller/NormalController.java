package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/normal")
public class NormalController {
    @RequestMapping(method = RequestMethod.GET)
    public String home(Authentication authentication){
        UserEntity userDetails = (UserEntity) authentication.getPrincipal();

        return "integrated:normal";
    }
}
