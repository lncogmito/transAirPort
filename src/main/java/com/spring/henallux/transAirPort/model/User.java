package com.spring.henallux.transAirPort.model;

import com.spring.henallux.transAirPort.controller.Constants;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class User {
    @NotEmpty
    private String username;

    @Size(min= Constants.MIN_CHAR_PASSWORD)
    @NotEmpty
    private String password;

    public User(){}

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setUsername(String newUser){
        username = newUser;
    }
    public void setPassword(String newPassword){
        password = newPassword;
    }
}
