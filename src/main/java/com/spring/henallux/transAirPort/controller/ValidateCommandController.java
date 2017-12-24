package com.spring.henallux.transAirPort.controller;

import com.spring.henallux.transAirPort.dataAccess.dao.AddressDAO;
import com.spring.henallux.transAirPort.dataAccess.dao.OrderDAO;
import com.spring.henallux.transAirPort.dataAccess.dao.UserDAO;
import com.spring.henallux.transAirPort.dataAccess.entity.OrderEntity;
import com.spring.henallux.transAirPort.dataAccess.entity.OrderLineEntity;
import com.spring.henallux.transAirPort.dataAccess.util.ProviderConverter;
import com.spring.henallux.transAirPort.model.Address;
import com.spring.henallux.transAirPort.model.OrderLine;
import com.spring.henallux.transAirPort.model.User;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "/validateCommand")
@SessionAttributes({ToolKit.BASKET})
public class ValidateCommandController {
    private final MessageSource messageSource;
    private UserDAO userDAO;
    private AddressDAO addressDAO;
    private OrderDAO orderDAO;
    private ProviderConverter providerConverter;

    public ValidateCommandController(MessageSource messageSource, UserDAO userDAO, AddressDAO addressDAO,OrderDAO orderDAO, ProviderConverter providerConverter){
        this.messageSource = messageSource;
        this.userDAO = userDAO;
        this.addressDAO = addressDAO;
        this.providerConverter = providerConverter;
        this.orderDAO = orderDAO;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale) {
        model.addAttribute("title", messageSource.getMessage("titleValidateCommand", null, locale));
        model.addAttribute("totalCostAllReducInclusive", ToolKit.totalCostAllReducInclusive);
        return "integrated:validateCommand";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String getSuccess(Model model, Locale locale, @ModelAttribute(value = ToolKit.BASKET)HashMap<Integer, OrderLine> hashMap, Authentication authentication) {
        model.addAttribute("title", messageSource.getMessage("titleValidateCommand", null, locale));

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setUser(userDAO.findEntityByUsername(authentication.getName()));
        orderEntity.setDeliveryAddress(addressDAO.findOne((long)1));

        orderDAO.saveOrder(orderEntity);
            OrderLineEntity orderLineEntity;
            int iLines = 1;
            for(OrderLine orderLine:hashMap.values()){
                orderLineEntity = new OrderLineEntity();
                orderLineEntity.setOrder(orderEntity);
                orderLineEntity.setLineNumber(iLines);
                orderLineEntity.setProduct(providerConverter.productModelToProductEntity(orderLine.getProduct()));
                orderLineEntity.setQuantity(orderLine.getQuantity());
                orderLineEntity.setPrice(orderLine.getPrice());

                orderDAO.saveOrderLine(orderLineEntity);

                iLines++;
            }
        hashMap.clear();
        ToolKit.nbLines = 0;

        return "redirect:/home";
    }





}
