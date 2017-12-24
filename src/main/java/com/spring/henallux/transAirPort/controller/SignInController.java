package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.dao.AddressDAO;
import com.spring.henallux.transAirPort.dataAccess.dao.ProductInfoDAO;
import com.spring.henallux.transAirPort.dataAccess.dao.UserDAO;
import com.spring.henallux.transAirPort.dataAccess.entity.AddressEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.LocalityEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.UserEntity;
import com.spring.henallux.transAirPort.model.UserSignInForm;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping(value = "/signIn")
public class SignInController {
    private final MessageSource messageSource;
    private UserDAO userDAO;
    private AddressDAO addressDAO;

    @Autowired
    public SignInController(MessageSource messageSource, UserDAO userDAO, AddressDAO addressDAO){
        this.messageSource = messageSource;
        this.userDAO = userDAO;
        this.addressDAO = addressDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale){
        model.addAttribute("title", messageSource.getMessage("titleSignIn",null,locale));

        model.addAttribute("newUser", new UserSignInForm());
        return "integrated:signIn";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(@Valid @ModelAttribute(value = "newUser")UserSignInForm userSignInForm, final BindingResult errors){
        if(!errors.hasErrors() && userSignInForm.getEmail().equals(userSignInForm.getEmailConfirm()) && userSignInForm.getPassword().equals(userSignInForm.getPasswordConfirm())){
            UserEntity newUser = new UserEntity();
            newUser.setUsername(userSignInForm.getUsername());
            newUser.setPassword(new BCryptPasswordEncoder().encode(userSignInForm.getPassword()));
            newUser.setEmail(userSignInForm.getEmail());
            newUser.setAuthorities("ROLE_USER");
            newUser.setAccountNonExpired(true);
            newUser.setAccountNonLocked(true);
            newUser.setCredentialsNonExpired(true);
            newUser.setEnabled(true);

            LocalityEntity localityEntity = new LocalityEntity();
            localityEntity.setCountry(userSignInForm.getCountry());
            localityEntity.setName(userSignInForm.getLocalityName());
            localityEntity.setPostalCode(userSignInForm.getPostalCode());
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setStreet(userSignInForm.getStreet());
            addressEntity.setHouseNumber(userSignInForm.getHouseNumber());
            if(userSignInForm.getBoxNumber() != null)
                addressEntity.setBoxNumber(userSignInForm.getBoxNumber());

            newUser.setAddress(addressEntity);

            addressDAO.saveLocality(localityEntity);

            addressEntity.setLocality(addressDAO.findOneByNameAndPostalCode(userSignInForm.getLocalityName(),userSignInForm.getPostalCode()));

            addressDAO.saveAddress(addressEntity);
            if(userDAO.save(newUser))
                return "redirect:/home";
            else
                return "integrated:signIn";
        }
        else{
            return "integrated:signIn";
        }


    }

}
