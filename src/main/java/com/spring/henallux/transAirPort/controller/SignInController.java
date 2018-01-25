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
import org.springframework.web.bind.annotation.RequestParam;

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
    public String getFormData(Model model,Locale locale, @Valid @ModelAttribute(value = "newUser")UserSignInForm userSignInForm, final BindingResult errors){
        model.addAttribute("title", messageSource.getMessage("titleSignIn",null,locale));

        String errorMsg = "";
        if(!errors.hasErrors()){
            UserEntity newUser = new UserEntity();

            if(userDAO.findEntityByUsername(userSignInForm.getUsername()) != null)
                if(locale.getLanguage() == "fr")
                    errorMsg += "Ce pseudo est déjà existant<br/>";
                else
                    errorMsg += "This pseudo is already taken<br/>";
            if(!userSignInForm.getEmail().equals(userSignInForm.getEmailConfirm()))
                if(locale.getLanguage() == "fr")
                    errorMsg += "Les emails encodés ne sont pas identiques<br/>";
                else
                    errorMsg += "The emails are different<br/>";
            else{
                if(userDAO.findEntityByEmail(userSignInForm.getEmail()) != null){
                    if(locale.getLanguage() == "fr")
                        errorMsg += "Cet email est déjà existant<br/>";
                    else
                        errorMsg += "This email is already taken<br/>";
                }
            }
            if(!userSignInForm.getPassword().equals(userSignInForm.getPasswordConfirm())){
                if(locale.getLanguage() == "fr")
                    errorMsg += "Les mots de passe encodés ne sont pas identiques";
                else
                    errorMsg += "The passwords are different<br/>";
            }

            if(errorMsg.equals("")){
                newUser.setUsername(userSignInForm.getUsername());
                newUser.setPassword(new BCryptPasswordEncoder().encode(userSignInForm.getPassword()));
                newUser.setEmail(userSignInForm.getEmail());
                newUser.setAuthorities("ROLE_USER");
                newUser.setAccountNonExpired(true);
                newUser.setAccountNonLocked(true);
                newUser.setCredentialsNonExpired(true);
                newUser.setEnabled(true);

                LocalityEntity localityEntity = addressDAO.findOneByNameAndPostalCode(userSignInForm.getLocalityName(),userSignInForm.getPostalCode());
                if(localityEntity == null){
                    localityEntity = new LocalityEntity();
                    localityEntity.setCountry(userSignInForm.getCountry());
                    localityEntity.setName(userSignInForm.getLocalityName());
                    localityEntity.setPostalCode(userSignInForm.getPostalCode());
                    addressDAO.saveLocality(localityEntity);

                    //charger ce qu'il y a en BD pour avoir l'id avec
                    localityEntity = addressDAO.findOneByNameAndPostalCode(userSignInForm.getLocalityName(),userSignInForm.getPostalCode());
                }

                AddressEntity addressEntity;
                if(userSignInForm.getBoxNumber() == null)
                     addressEntity = addressDAO.findOneByStreetAndHouseNumber(userSignInForm.getStreet(), userSignInForm.getBoxNumber());
                else
                    addressEntity = addressDAO.findOneByStreetAndHouseNumberAndBoxNumber(userSignInForm.getStreet(), userSignInForm.getHouseNumber(), userSignInForm.getBoxNumber());

                if(addressEntity == null){
                    addressEntity = new AddressEntity();
                    addressEntity.setStreet(userSignInForm.getStreet());
                    addressEntity.setHouseNumber(userSignInForm.getHouseNumber());
                    if(userSignInForm.getBoxNumber() != null) {
                        addressEntity.setBoxNumber(userSignInForm.getBoxNumber());
                    }
                }

                addressEntity.setLocality(localityEntity);
                addressDAO.saveAddress(addressEntity);

                newUser.setAddress(addressEntity);


                if(userDAO.save(newUser))
                    return "redirect:/home";
            }

        }

        model.addAttribute("msg", errorMsg);
        return "integrated:signIn";


    }

}
