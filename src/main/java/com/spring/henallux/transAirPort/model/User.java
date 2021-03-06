package com.spring.henallux.transAirPort.model;

import com.spring.henallux.transAirPort.controller.ToolKit;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class User {
    //TODO: refaire cette class clean code bof. +1

    @NotEmpty
    private String username;

    private String email;

    @Size(min= ToolKit.MIN_CHAR_PASSWORD)
    @NotEmpty
    private String password;

    private String authorities;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;

    private Address address;

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


    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
