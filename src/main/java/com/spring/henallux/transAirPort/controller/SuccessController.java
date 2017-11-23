package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="success")
@SessionAttributes({Constants.CURRENT_USER})
public class SuccessController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "integrated:success";
    }
}
